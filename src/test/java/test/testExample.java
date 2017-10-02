/*package test;

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
		driver.get("https://www.dev.123loadboard.com/login/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"signin\"]/input[1]")).sendKeys("username");
		driver.findElement(By.xpath("//*[@id=\"signin\"]/input[2]")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id=\"signin\"]/input[5]")).click();
		String text = driver.findElement(By.xpath("//*[@text='The email/username or password you entered is incorrect. Please verify your login details and try again.']")).getText();
		//String text = driver.findElement(By.linkText(""))
		System.out.println(text);
		
	}

	
	
}
*/