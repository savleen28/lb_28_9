package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Page.SignInPage;
import Page.SignUpPage1;
import Page.SignUpStep2Page;
import Page.StartPage;
import reporting.CustomAssert;
import Base.BaseActions;
import Base.BasePage;
import ru.yandex.qatools.allure.annotations.Step;

public class GeneralActions extends BasePage  {
	/*WebDriver driver;

	public GeneralActions(WebDriver driver) {
		this.driver = driver;
	}*/
	
	 public GeneralActions() {
		 PageFactory.initElements(driver(), this);
	 }
	 
	 @Step
	    public void login(String username, String password) {
	        CustomAssert.hardAssertTrue(new StartPage().isPageOpened(), "Expected start page to be opened for logging in.");
	        StartPage startPage = new StartPage();
	        SignInPage signInPage = startPage.clickSignInButton();
	        signInPage.typeUsername(username).typePassword(password).clickSignIn();
	    }
	 

	@Step
	public SignUpPage1 typeSignUpInfo(String emailAddress, String password, String firstName, String lastName,
			String companyName, String PhoneNumber) {
		return PageFactory.initElements(driver(), SignUpPage1.class).typeEmail(emailAddress).typePassword(password).typeFirstName(firstName)
				.typeLastName(lastName).typeCompanyName(companyName).typePhoneNumber(PhoneNumber);
	}

	@Step
	public SignUpStep2Page typeSignUpStep2Info(String nameOnCard, String cardNo, String month,
			String year, String csc) {
		return PageFactory.initElements(driver(), SignUpStep2Page.class).typeNameOnCard(nameOnCard).typeCardNumber(cardNo)
				.selectMonth(month).selectYear(year).typeCsc(csc);
	}
	
	

}

