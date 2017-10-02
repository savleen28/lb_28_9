package Page;

import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import ru.yandex.qatools.allure.annotations.Step;

public class ActionBar extends BasePage {
	
	public ActionBar() {
		PageFactory.initElements(driver(), this);
	}
	

	 @Step
	    public void clickBackButton() {
		 navigateBackButton();
	    }

}
