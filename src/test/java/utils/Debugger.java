/*package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BasePage;

public class Debugger {

    public enum SEVERITY {
        INFO,
        ERROR,
        WARNING
    }

    public Debugger() {}

    public static void printFile(File file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Logger.info("\n>--------- Start Reading file " + file.getPath());
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException msg) {
            Logger.error(msg.getMessage());
        } catch (IOException msg) {
            Logger.error(msg.getMessage());
        }
        Logger.info("<--------- End Reading file " + file.getName() + "\n");
    }

    public static void printPageContent(String header){
        Logger.info("\nPrint page content: " + header);
        printPageContent();
    }

    public static void printPageContent(){
       // printFile(Attachments.dumpPageXML());
    }


    public static void listDirectoryContent(String dir, String[] filesToRead) {
        Logger.info("\n>--------- Start Listing directory " + dir);
        File f = new File(dir);
        File[] list = f.listFiles();
        if (list == null) {
            return;
        }
        for (File entry : list) {
            if (entry.isDirectory()) {
                if (entry.getName().equals("dependency-jars")) {
                    Logger.info("Skipping Dir: " + entry.getName());
                    continue;
                }
                listDirectoryContent(entry.getAbsolutePath(), filesToRead);
            } else {
                double bytes = entry.length();
                double kilobytes = (bytes / 1024);
                System.out.println(entry.getPath() + " (" + kilobytes + " Kb)");
                for (String fn : filesToRead) {
                    if (entry.getName().equals(fn) || entry.getName().contains(fn)) {
                        printFile(entry);
                    }
                }
            }
        }
        Logger.info("<--------- End Listing directory " + dir);
    }

    public static String geAllElements() {
        List<WebElement> els = BasePage.driver().findElements(By.xpath("//*"));
        return "All elements count = " + els.size();
    }

    public static void dumpAllElements() {
    	 List<WebElement> els = BasePage.driver().findElements(By.xpath("//*"));
        Logger.info("All elements count = " + els.size());
    }

    public static void listDirectoryContent(String dir) {
        String[] dummy = {};
        listDirectoryContent(dir, dummy);
    }


    private static String getTime() {
        return ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public static String getZTime() {
        String tz = ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME); // 2017-06-30T17:53:14.683Z[Etc/UTC]
        return tz.replaceAll("(\\d+-\\d+-\\d+)T(\\d+:\\d+).*(\\[.*\\])", "$1 $2 $3"); // 2017-06-30 17:53 [Etc/UTC]
    }

    public static class Logger {

        public Logger() {}

        private static void log(String text, SEVERITY severity) {
            String logText = getTime() + "\t[LOG::" + severity + "] " + text;
            System.out.println(logText);
        }

        private static void logWithoutTime(String text, SEVERITY severity) {
            String logText = "[LOG::" + severity + "]\t" + text;
            System.out.println(logText);
        }

        public static void print(String text) {
            logWithoutTime(text, SEVERITY.INFO);
        }

        @Step
        public static void info(String text) {
            log(text, SEVERITY.INFO);
        }

        @Step
        public static void warn(String text) {
            log(text, SEVERITY.WARNING);
        }

        @Step
        public static void error(String text) {
            log(text, SEVERITY.ERROR);
        }

        public static void printRunInfo() {
            print("~~~~~~~~~~~~~~~~ Run info ~~~~~~~~~~~~~~~~");
            print("Date/Time: " + getZTime());
            print("Platform: " + Properties.getPlatform());
            print("Product build info: " + Properties.buildInfo);
            print("Run type: " + (Properties.isRunTypeAWS ? "AWS" : "Local"));
            print("Device Info: " + Properties.getAppiumDeviceName() + " " + Properties.getAppiumApiVersion());
            print("Test commit Hash: " + Properties.getCommitHash());
            print("Jira call state: " + Properties.isJiraAPIEnabled());
            if (Properties.isRunTypeAWS) {
                print("Run name: " + Properties.getRunName());
            }
            print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }


    public static class Timer {

        public static LocalTime startTime = LocalTime.now();;
        public static LocalTime endTime = startTime;

        public static void capterTime() {
            startTime = LocalTime.now();
            endTime = startTime;
        }

        public static String getElapsedTime() {
            endTime = LocalTime.now();
            Duration timeElapsed = Duration.between(startTime, endTime);
            int minutes = (int) timeElapsed.toMinutes();
            int seconds = (int) timeElapsed.getSeconds() - minutes * 60;
            return (minutes+":"+String.format("%02d", seconds));
        }
    }



    public static void printCommonCapabilities() {
        String[] capList = {"automationName", "platformName", "platformVersion", "deviceName", "app",
                "browserName", "newCommandTimeout", "language", "locale", "udid", "orientation",
                "autoWebview", "noReset", "fullReset", "eventTimings", "enablePerformanceLogging"};
        for (String cap : capList) {
            getCapabilityValue(cap);
        }
    }

    public static void printIOSCapabilities() {
        String[] capList = {"calendarFormat", "bundleId", "udid", "launchTimeout", "locationServicesEnabled",
                "locationServicesAuthorized", "autoAcceptAlerts", "autoDismissAlerts", "nativeInstrumentsLib",
                "nativeWebTap", "safariInitialUrl", "safariAllowPopups", "safariIgnoreFraudWarning",
                "safariOpenLinksInBackground", "keepKeyChains", "localizableStringsDir", "processArguments",
                "interKeyDelay", "showIOSLog", "sendKeyStrategy", "screenshotWaitTimeout", "waitForAppScript",
                "webviewConnectRetries", "appName", "customSSLCert"};
        for (String cap : capList) {
            getCapabilityValue(cap);
        }
    }

    public static void getCapabilityValue(String capName) {
        String capValue = BasePage.driver().getCapabilities().getCapability(capName) != null
                ? BasePage.driver().getCapabilities().getCapability(capName).toString() : "";
        Logger.info("Capability " + capName + " = " + capValue);
    }
}

*/