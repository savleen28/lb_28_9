package test;

import static org.testng.Assert.assertTrue;

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
		driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[7]/a")).click();
		/*driver.findElement(By.xpath("//*[@id=\"emailVerification\"]")).sendKeys("123lbtester@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/section[1]/input[2]")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/section[3]/input[1]")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/section[3]/input[2]")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/section[3]/input[4]")).sendKeys("8005551212");*/
		driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/input")).click();
		
		//String text = driver.findElement(By.className("form--error")).getText();
		//System.out.println("the text is ---> " + text);
		
		String password_err = driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/section[1]/div[2]")).getText();
		String firstName_err = driver.findElement(By.xpath("//*[@id=\"signup--forms\"]/form/section[3]/div[1]")).getText();
		System.out.println(password_err + firstName_err);
		
		
	}
	
	/*public static void main(String[] args) {
		String url = "https://member.dev.123loadboard.com/signup/verify/a8a5a90f-fd90-492a-8cdf-940bdd55a82b";
		String suburl = url.substring(50);
		System.out.println(suburl);
		String newurl = "https://member.dev.123loadboard.com/m/verify.aspx?activationcode=" + suburl;
		System.out.println(newurl);
	}*/

	
	
}
