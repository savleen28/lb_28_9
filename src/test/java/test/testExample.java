package test;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testExample {
	
	public static WebDriver driver;
	@Test
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
		
		
		
		
	}
	
	/*public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SavleenB\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		//String baseUrl = "http://www.google.com";
		    driver.get("http://twitter.com");
		    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

		    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1)); //switches to new tab
		    driver.get("https://www.facebook.com");

		    driver.switchTo().window(tabs.get(0)); // switch back to main screen        
		    driver.get("https://www.news.google.com");
	}*/

	
	
}
