package Page;

import ru.yandex.qatools.allure.annotations.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import Base.BasePage;
import utils.Constants;

import Configuration.config;

public class StartPage extends BasePage{
	
	/*WebDriver driver;
	public StartPage(WebDriver driver){
		this.driver = driver;
	}*/
	 public StartPage() {
		 PageFactory.initElements(driver(), this);
	 }
	 
	 
	
	@FindBy(linkText = config.signInButton)
	public WebElement signInButton;
	
	@FindBy(xpath = config.trialButton)
	public WebElement trialButton;
	
	@Step
	public StartPage waitForPageToLoad() {
		waitForElementVisibility(signInButton);	
		return this;
	}
	
	@Step
    public boolean isPageOpened() {
        Boolean promise = isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, trialButton)
                && isElementDisplayed(Constants.ELEMENT_1_TIMEOUT_SECONDS, signInButton);
       // Attachments.takeScreenshot();
        return promise;
    }
	
	@Step
    public boolean isPageOpened(int time) {
        Boolean promise = isElementDisplayed(time, trialButton)
                && isElementDisplayed(Constants.ELEMENT_1_TIMEOUT_SECONDS, signInButton);
        return promise;
	}
	
	
    public SignInPage clickSignInButton() {
      WebElement signInButton = driver().findElement(By.linkText("Sign in"));
      click(signInButton);
      return PageFactory.initElements(driver(), SignInPage.class);
    }
	
	
	
	

}
