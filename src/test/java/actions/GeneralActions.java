package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Page.SignUpPage;
import Page.SignUpStep2Page;
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
	public SignUpPage typeSignUpInfo(String emailAddress, String password, String firstName, String lastName,
			String companyName, String PhoneNumber) {
		return PageFactory.initElements(driver(), SignUpPage.class).typeEmail(emailAddress).typePassword(password).typeFirstName(firstName)
				.typeLastName(lastName).typeCompanyName(companyName).typePhoneNumber(PhoneNumber);
	}

	@Step
	public SignUpStep2Page typeSignUpStep2Info(String nameOnCard, String cardNo, String month,
			String year, String csc) {
		return PageFactory.initElements(driver(), SignUpStep2Page.class).typeNameOnCard(nameOnCard).typeCardNumber(cardNo)
				.selectMonth(month).selectYear(year).typeCsc(csc);
	}

}

