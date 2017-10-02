package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import Configuration.config;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Constants;

public class ForgotPasswordPage extends BasePage{

	public ForgotPasswordPage() {
		PageFactory.initElements(driver(), this);
	}
	
	@FindBy(xpath = config.resetPasswordButton)
	public WebElement resetPassword;
	
	@FindBy(xpath = config.resetEmailTextBox)
	public WebElement resetEmail;
	
	@Step
    public boolean isPageOpened() {
        Boolean promise = isElementPresent(Constants.ELEMENT_30_TIMEOUT_SECONDS, resetPassword);
       // Attachments.takeScreenshot();
        return promise;
    }
	
	
}
