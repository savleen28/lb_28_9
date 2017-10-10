package Base;



import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import properties.Properties;
import reporting.Attachments;

public class BaseTest {
	
	
	public static WebDriver driver;
	private static String TestErrorInfo = "";
	
	
	
	public static WebDriver driver()
	{
		
		return driver;
	}
	
	
	@BeforeClass
    public void setUp() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void setUpForAWSRun() throws MalformedURLException {
		Attachments.attachPassedParameters();
		if(Properties.isChrome) {
			try {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SavleenB\\Softwares\\chromedriver_win32\\chromedriver.exe");
				driver =new ChromeDriver();
				driver.get("https://www.dev.123loadboard.com/");
				driver.manage().window().maximize();
			}
			catch (Exception e){
				e.printStackTrace();
				TestErrorInfo = "Unable to open a new browser";
			}
		}
		
		else {
			try {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\SavleenB\\Softwares\\geckodriver-v0.18.0-win32\\geckodriverdriver.exe");
				driver = new FirefoxDriver();
				
			}
			
			catch (Exception e) {
				e.printStackTrace();
				TestErrorInfo = "Unable to open a new browser";
			}
		}
		 new BasePage().wait(5);
		
	}
	
	
	

	
	
}

