package Base;



import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import ru.yandex.qatools.allure.annotations.Step;
import utils.Constants;

public class BasePage /*extends BaseTest*/ {
	public static WebDriver driver() {   
		return BaseTest.driver();
	}
	
	
	
	
	/*WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	public BasePage() {
		
	}*/
	
	

	public void waitForElementVisibility(WebElement element) {
		waitForElementVisibility(Constants.ELEMENT_3_TIMEOUT_SECONDS, element);
	}

	public void waitForElementVisibility(int timeout, WebElement element) {
		new WebDriverWait(driver(), timeout).until(ExpectedConditions.visibilityOf(element));

	}

	public boolean isElementPresent(WebElement locator) {
		try {
			waitForElementVisibility(Constants.ELEMENT_30_TIMEOUT_SECONDS, locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected boolean isElementDisplayed(int timeout, WebElement locator) {
        try {
            new WebDriverWait(driver(), timeout).until(ExpectedConditions.visibilityOf(locator));
         
            return true;
        } catch (Exception te) {
            return false;
        }
    }

	@Step
	public void click(WebElement element) {
		element.click();
	}

	@Step
	public boolean isElementPresent(int timeout, WebElement Element) {
		try {
			waitForElementVisibility(timeout, Element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Step
	protected boolean isBelowOf(WebElement aboveElement, WebElement belowElement) {
		return BaseActions.getLocPointY(aboveElement) < BaseActions.getLocPointY(belowElement);
	}

	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void waitMili(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	 protected void type(String value, WebElement element) {
	        wait(1);
	        element.clear();
	        element.sendKeys(value);
	        
	    }

}

