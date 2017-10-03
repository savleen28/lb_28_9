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
		driver.get("https://www.dev.123loadboard.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"top-menu\"]/li[7]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"form\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/section/div/form/input[1]")).sendKeys("abc");
		driver.findElement(By.xpath("//*[@id=\"main\"]/section/div/form/input[2]")).click();
		String text = driver.findElement(By.xpath("//*[@id=\"main\"]/section/div/form/div")).getText();
		System.out.println(text);
		
		
		
	}

	
	
}
