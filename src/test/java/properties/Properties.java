package properties;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Scanner;


public class Properties {

    public static String browser = "";
    
    public static boolean isChrome = getPlatform().equalsIgnoreCase("Chrome");
    public static boolean isFirefox = getPlatform().equalsIgnoreCase("Firefox");
   

 

    public static String getConfigDir() {
        return System.getProperty(PropertiesNames.CONFIG_DIR.toString());
    }
    
    public static String getBrowser() {
    	return System.getProperty(PropertiesNames.WEB_BROWSER.toString());
    }
    
    public static String getPlatform() {
    	if ( browser.isEmpty()) {
    		browser = System.getProperty(PropertiesNames.WEB_BROWSER.toString());
    		if(!browser.equalsIgnoreCase("Chrome") && !browser.equalsIgnoreCase("Firefox")) {
    			PropertiesNames.WEB_BROWSER.setValue("Chrome");
    			browser = "Chrome";
    		}
    	}
    	
    	return browser;
    }
    
    

    
}

