package Base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	
	public static WebDriver driver /*=new ChromeDriver()*/;        
	
	
	
	public static WebDriver driver()
	{
		
		return driver;
	}
	
	
	@BeforeClass(alwaysRun=true)
    public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BEDI\\Downloads\\software\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://www.dev.123loadboard.com/");
		//driver.manage().window().maximize();
	}
	
	/*@BeforeClass
	public void openWebSite() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SavleenB\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://www.dev.123loadboard.com/");
		driver.manage().window().maximize();
	}*/
	

	
	
}

