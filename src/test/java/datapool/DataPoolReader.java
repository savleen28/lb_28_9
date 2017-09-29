package datapool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import properties.Properties;

public class DataPoolReader {
    private static final String DATAPOOL_NAME = "datapool.xml";

    private static final String XML_DATA_TAG = "data";
    private static final String XML_BROWSER_TAG = "browser";
    private static final String XML_BROWSER_TAG_TYPE_ATTR = "type";
    private static final String XML_CREDENTIALS_TAG = "credentials";
    private static final String XML_CREDENTIALS_TAG_NAME_ATTR = "name";
    private static final String XML_ARG_TAG = "arg";
    Document datapool;
    String filePath;
    List<Node> data;

    public DataPoolReader() {
        try {
            filePath = Paths.get(Properties.getConfigDir(), DATAPOOL_NAME).toString();
            datapool = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(filePath);
            datapool.getDocumentElement().normalize();

            data = FilterNodeList(datapool.getChildNodes(), XML_DATA_TAG);

        } catch (Exception e) {
            System.err.println("Unable to read DataPool file: " + filePath + "! " + e.getMessage());
            e.printStackTrace();
        }
    }


    private List<Node> FilterCredentialsData(String credentialsName) {
        List<Node> credentialsList = new ArrayList<>();

        // for each DATA element
        for (Node d : data) {
            // select BROWSER children
            List<Node> browserData = FilterNodeList(
                    d.getChildNodes(), XML_BROWSER_TAG,
                    XML_BROWSER_TAG_TYPE_ATTR, "*");

            for (Node bd : browserData) {
                // filter CREDENTIALS data
                List<Node> credentials = FilterNodeList(
                        bd.getChildNodes(), XML_CREDENTIALS_TAG,
                        XML_CREDENTIALS_TAG_NAME_ATTR, credentialsName);

                // add all to output list
                credentialsList.addAll(credentials);
            }
        }

        return credentialsList;
    }

    public Object[][] GetCredentials(String credentialsName) {
        List<Node> credentials = FilterCredentialsData(credentialsName);
        List<List<String>> returnData = new ArrayList<>();

        for (Node c : credentials) {
            List<String> args = FilterNodeList(c.getChildNodes(), XML_ARG_TAG).stream().map(n -> n.getTextContent()).collect(Collectors.toList());
            returnData.add(args);
        }

        Object[][] matrix = new Object[returnData.size()][];
        for (int i = 0; i < returnData.size(); i++) {
            matrix[i] = returnData.get(i).toArray();
        }

        return matrix;
    }

    public void SetCredentials(String credentialsName, String value) {
        List<Node> credentials = FilterCredentialsData(credentialsName);
        credentials.get(0).getChildNodes().item(1).getFirstChild().setNodeValue(value);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        DOMSource source = new DOMSource(datapool);
        StreamResult result = new StreamResult(new File(filePath));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    private List<Node> TransformNodeList(NodeList list) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            nodes.add(list.item(i));
        }

        return nodes;
    }

    private List<Node> FilterNodeList(NodeList list, String tagFilter) {
        List<Node> nodes = TransformNodeList(list);
        List<Node> filteredNodes = nodes.stream().filter(n -> {
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                return ((Element) n).getTagName().toLowerCase().equals(tagFilter.toLowerCase());
            }
            return false;
        }).collect(Collectors.toList());

        return filteredNodes;
    }

    private List<Node> FilterNodeList(NodeList list, String tagFilter, String attr, String attrValue) {
        List<Node> nodes = FilterNodeList(list, tagFilter);
        List<Node> filteredNodes = nodes.stream().filter(new Predicate<Node>() {
            @Override
            public boolean test(Node n) {
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    String attribute = ((Element) n).getAttribute(attr);
                    return attribute != null && attribute.toLowerCase().equals(attrValue.toLowerCase());
                }
                return false;
            }
        }).collect(Collectors.toList());

        return filteredNodes;
    }
}

