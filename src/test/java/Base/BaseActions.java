package Base;


import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import org.openqa.selenium.*;
import ru.yandex.qatools.allure.annotations.Step;

public class BaseActions {
	static WebDriver driver;

	public BaseActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void closeWebSite() {
		driver.close();
	}
	
	public static int getLocPointY(WebElement element) {
		return element.getLocation().getY();
	}
	
	public static int getLocPointX(WebElement element) {
		return element.getLocation().getX();
	}
	@Step
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	@Step
    public static void clickOnBackButton() {
        driver.navigate().back();
    }
	
	 @Step
	    public boolean compareArrayLists(ArrayList list1, ArrayList list2) {
	        if (!(list1.size() == list2.size())) return false;
	        for (int i = 0; i < list1.size(); i++) {
	            if (!list1.get(i).equals(list2.get(i))) {
	                return false;
	            }
	        }
	        return true;
	    }
	
}

