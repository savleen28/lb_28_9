package properties;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Scanner;


public class Properties {

    public static String runUrl = "";
    public static String runName = "";
    public static String appium_platform = "";
    public static String device_name = "";
    public static String jiraCall = "";
    public static String ellapesTime = "n/a";

   

 

    public static String getConfigDir() {
        return System.getProperty(PropertiesNames.CONFIG_DIR.toString());
    }

    
}

