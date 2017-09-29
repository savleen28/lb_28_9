package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Random;
import Page.SignInPage;
import Page.SignUpPage;
import Page.SignUpStep2Page;
import Page.StartPage;
import actions.Actions;
import reporting.CustomAssert;
import ru.yandex.qatools.allure.annotations.Title;
import actions.GeneralActions;
import Base.BaseTest;

public class SignInUpTest extends BaseTest{
	@Title("TST-1")
	@Test(testName = "TST-1", description = "Sign In screen (Functional), 'Signing In in 123Loadboard.'")
	public void signInScreenFunctional() /*public static void main(String[] args)*/ throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SavleenB\\Softwares\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new HtmlUnitDriver();
		//WebDriver driver = new ChromeDriver();
		/*driver.get("https://www.dev.123loadboard.com/");
		driver.manage().window().maximize();*/
		
		//StartPage startPage = PageFactory.initElements(driver, StartPage.class);
		StartPage startPage = new StartPage();
		SignInPage signInPage = startPage.clickSignInButton();
		//CustomAssert.hardAssertTrue(signInPage.isPageOpened(), "Start Page was not opened"); //check this
		//Create new user
		SignUpPage signUpPage = signInPage.clickSignUpLink();
		//CustomAssert.hardAssertFalse(signUpPage.isPageOpened(), "Sign Up page was not opened");
		String firstName = "FirstName" + Random.genFirstNameRandomNo();
		String lastName = "LastName" + Random.genLastNameRandomNo();
		String unverifiedEmail = "qa" + Random.genShortRandNumber() + "@test.123loadboard.us";
		String unverifiedPassword = "password";
        String phoneNumber = "8005551212";
        String companyName = "Dummy Company";
        String cardNo = "4242424242424242";
        String month = "01 - January";
        String year = "2024";
        String csc = "024";
       // GeneralActions generalActions = PageFactory.initElements(driver, GeneralActions.class);
        GeneralActions generalActions = new GeneralActions();
        generalActions.typeSignUpInfo(unverifiedEmail, unverifiedPassword, firstName, lastName, companyName, phoneNumber);
        SignUpStep2Page signUpStep2 = signUpPage.clickSignUpButton();
        //Thread.sleep(10000L);
        generalActions.typeSignUpStep2Info(firstName, cardNo, month, year, csc);
        
        signUpStep2.clickTerms();
        signUpStep2.clickApply();
		
	}
	
	

}
