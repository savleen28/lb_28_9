package test;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testExample {
	
	public static WebDriver driver;
	/*@Test
	public void logIn() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SavleenB\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://www.dev.123loadboard.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[7]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"emailVerification\"]")).sendKeys("abcd@test.123loadboard.us");
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/section[1]/input[2]")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/section[3]/input[1]")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/section[3]/input[2]")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/section[3]/input[4]")).sendKeys("8005551212");
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/input")).click();
		driver.findElement(By.xpath("//*[@id=\"plansform\"]/div[1]/div/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"promocode\"]")).sendKeys("92000");
		driver.findElement(By.xpath("//*[@id=\"promoButton\"]")).click();
		Thread.sleep(5000L);
		String text1 = driver.findElement(By.xpath("//*[@id=\"plansContainer\"]/section/div/div[1]/div[1]/div/span[2]")).getText();
		String text2 = driver.findElement(By.xpath("//*[@id=\"plansContainer\"]/section/div/div[1]/div[2]/div/span[2]")).getText();
		String text3 = driver.findElement(By.xpath("//*[@id=\"plansContainer\"]/section/div/div[1]/div[3]/div/span[2]")).getText();
		System.out.println(text1 + " "+ text2 + " "+text3);
		
		
		
		
	}*/
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SavleenB\\Softwares\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		    Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
		    System.out.println(browserName);
		    String os = cap.getPlatform().toString();
		    System.out.println(os);
		    String v = cap.getVersion().toString();
		    System.out.println(v);
	}

	
	
}
