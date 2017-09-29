package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testExample {
	
	public static WebDriver driver;
	@Test
	public void logIn() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SavleenB\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://www.dev.123loadboard.com/signup/?step=3&plan=premium");
		driver.manage().window().maximize();
		//String s = driver.findElement(By.className("signup--forms")).getText();
		// (By.xpath("//div[@class='loginbox']/p"))
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form[2]/p/a")).click();
		String s = driver.findElement(By.className("resend-message valid")).getText();
		System.out.println(s);
	}

	
	
}
