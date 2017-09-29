/*package utils;

import org.apache.http.HttpStatus;
import org.apache.http.HttpStatus;
import javax.mail.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Base.BaseActions;

public class Mail {

    private static Folder openedFolder;
    private static Store store;
    private static String GmailHost = "imap.gmail.com";
    private static String TruckSiteHost = "vps.trucksitehosting.com";

    // Connect / disconnect

    private static void connect(String login, String password, String host) throws MessagingException {
        Matcher matcher = Pattern.compile(".(\\+[0-9a-zA-Z]+)@").matcher(login);
        String trueLogin = matcher.find() ? login.replace(matcher.group(1), "") : login;

        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getDefaultInstance(props, null);
        store = session.getStore("imaps");
        store.connect(host, trueLogin, password);
    }

    private static void disconnect() throws MessagingException {
        if (openedFolder != null) {
            openedFolder.close(true);
            openedFolder = null;
        }
        if (store != null) {
            store.close();
            store = null;
        }
    }

    private static String getHostByEmail(String email) {
        String host;
        switch (email.replaceAll("^.*@", "@")) {
            case "@test.123loadboard.us":
                host = TruckSiteHost;
                break;
            case "@gmail.com":
                host = GmailHost;
                break;
            default:
                Debugger.Logger.error("Unknown host. The email was: " + email);
                host = "Unknown";
        }
        return host;
    }

    // Get Emails / Messages

    private static List<Message> getUnreadMessages(String folderName) throws MessagingException {
        List<Message> unreadMessages = new ArrayList<>();
        if (store != null) {
            openedFolder = store.getFolder(folderName);
            openedFolder.open(Folder.READ_WRITE);
            Message messages[] = openedFolder.getMessages();
            for (Message msg : messages) {
                if (!msg.isSet(Flags.Flag.SEEN)) {
                    unreadMessages.add(msg);
                }
            }
        }
        return unreadMessages;
    }

    public static List<EmailMessage> waitForEmail(String email, String password, String folder, String expectedSubject, String expectedBody) {
        long startTime = System.currentTimeMillis();
        List<EmailMessage> messages = getEmailMessages(email, password, folder, expectedSubject, expectedBody);
        while (messages.size() == 0 && System.currentTimeMillis() - startTime < Constants.ELEMENT_120_TIMEOUT_SECONDS * 2000) {
            BaseActions.wait(5);
            messages = getEmailMessages(email, password, folder, expectedSubject, expectedBody);
        }
        return messages;
    }

    public static List<EmailMessage> getEmailMessages(String login, String password, String folder, String expectedSubject, String expectedBody) {
        List<EmailMessage> ret = new ArrayList<>();
        try {
            connect(login, password, getHostByEmail(login));
            List<Message> messages = getUnreadMessages(folder);
            for (Message msg : messages) {
                String from = "unknown";
                if (msg.getReplyTo().length >= 1) {
                    from = msg.getReplyTo()[0].toString();
                } else if (msg.getFrom().length >= 1) {
                    from = msg.getFrom()[0].toString();
                }

                String subject = msg.getSubject();
                Object content = msg.getContent();
                String body = "";
                if (content instanceof Multipart) {
                    int parts = ((Multipart) content).getCount();
                    for (int i = 0; i < parts; i++) {
                        body += ((Multipart) content).getBodyPart(i).getContent();
                    }
                } else {
                    body = (String) content;
                }

                EmailMessage email = new EmailMessage();
                email.setFrom(from);
                email.setBody(body);
                email.setSubject(subject);

                if (expectedSubject != null && !msg.getSubject().contains(expectedSubject)) {
                    msg.setFlag(Flags.Flag.SEEN, false);
                }
                if (expectedSubject != null && msg.getSubject().contains(expectedSubject)) {
                    if (expectedBody == null || email.getBody().contains(expectedBody)) {
                        ret.add(email);
                    }
                } else if (expectedSubject == null) {
                    ret.add(email);
                }
            }
        } catch (IOException | MessagingException nspe) {
            nspe.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (MessagingException mse) {
                mse.printStackTrace();
            }
        }
        return ret;
    }


    public static int getEmailsCount(String login, String password) {
        try {
            connect(login, password, getHostByEmail(login));
            openedFolder = store.getFolder("Inbox");
            openedFolder.open(Folder.READ_WRITE);
            Message messages[] = openedFolder.getMessages();
            return messages.length;
        } catch (MessagingException mse) {
            mse.printStackTrace();
            return -1;
        } finally {
            try {
                disconnect();
            } catch (MessagingException mse) {
                mse.printStackTrace();
            }
        }
    }

    // Clear Emails and Folders

    public static void clearInboxFolder(String login, String password) {

        long startTime = System.currentTimeMillis();
        clearFolder(login, password, "Inbox");
        while (getEmailsCount (login, password) != 0 && System.currentTimeMillis() - startTime < Constants.ELEMENT_30_TIMEOUT_SECONDS * 1000) {
            BaseActions.wait(3);
        }
        if (getEmailsCount (login, password) != 0) {
            Debugger.Logger.error("Unable to clean the Inbox");
        }
    }

    public static void clearFolder(String login, String password, String folderName) {
        try {
            connect(login, password, getHostByEmail(login));
            openedFolder = store.getFolder(folderName);
            openedFolder.open(Folder.READ_WRITE);
            Message messages[] = openedFolder.getMessages();
            for (Message msg : messages)
                msg.setFlag(Flags.Flag.DELETED, true);
        } catch (MessagingException mse) {
            mse.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (MessagingException mse) {
                mse.printStackTrace();
            }
        }

    }


    // Get Email data

    public static String getRecipient(Message msg) {
        try {
            return msg.getAllRecipients()[0].toString();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getEmailContent(Message msg) {
        try {
            Object content = msg.getContent();
            StringBuilder result = new StringBuilder();
            if (content instanceof String) {
                result.append(content);
            } else if (content instanceof Multipart) {
                Multipart parts = (Multipart) content;
                for (int i = 0; i < parts.getCount(); i++) {
                    BodyPart part = parts.getBodyPart(i);
                    if (part.getContent() instanceof String) {
                        result.append(part.getContent());
                    }
                }
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String parseEmailConfirmationLink(String content) {
        Scanner scanner = new Scanner(content);
        String link = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("http://") && !line.contains("cancel=true")) {
                link = line;
            }
            if (line.contains("Activation Code")) {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    link += line;
                    return link;
                }
            }
        }
        scanner.close();
        return "";
    }


    // Profile Email exchange

    public static void confirmProfileEmailUpdate(String login, String password, String sentEmail) {
        try {
            connect(login, password, getHostByEmail(login));
            long startTime = System.currentTimeMillis();
            while (!isLinkConfirmed(sentEmail) && System.currentTimeMillis() - startTime < Constants.ELEMENT_60_TIMEOUT_SECONDS * 1000) {
                BaseActions.wait(5);
            }
            Debugger.Logger.info("Was email found? : " + isLinkConfirmed(sentEmail));
            disconnect();
            Debugger.Logger.info("Disconnected");
        } catch (MessagingException mse) {
            mse.printStackTrace();
            return;
        }
    }

    public static boolean isLinkConfirmed(String recipient){
        boolean status = false;
        try {
            Debugger.Logger.info("Try to confirm the email");
            String content = "";
            String confirmationLink = "";
            int responseCode;
            openedFolder = store.getFolder("Inbox");
            openedFolder.open(Folder.READ_WRITE);
            Message messages[] = openedFolder.getMessages();
            Debugger.Logger.info("  emails count: " + messages.length);
            if (messages.length == 0) {
                return status;
            }
            for (int i=messages.length-1; i>=0; i--){
                Message msg = messages[i];
                Debugger.Logger.info(getRecipient(msg) + " : " + recipient);
                if (getRecipient(msg).equals(recipient)) {
                    content = getEmailContent(msg);
                    if (content.isEmpty()) {
                        Debugger.Logger.error("Content was empty");
                        continue;
                    }
                    Debugger.Logger.info("content : " + content);

                    confirmationLink = parseEmailConfirmationLink(content);
                    if (confirmationLink.isEmpty()) {
                        Debugger.Logger.error("Confirmation link was not found");
                        continue;
                    }
                    Debugger.Logger.info("confirmationLink : " + confirmationLink);
                    responseCode = confirmationLinkRequest(confirmationLink);
                    if (responseCode == HttpStatus.SC_OK) {
                        status = true;
                        Debugger.Logger.info("HttpStatus : OK");
                        break;
                    }
                }
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return status;
    }


    public static int confirmationLinkRequest(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int responseCode = conn.getResponseCode();
            Debugger.Logger.info("Confirmation Link Request Response Code : " + responseCode);
            conn.disconnect();
            return responseCode;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 400;
    }

}

*/