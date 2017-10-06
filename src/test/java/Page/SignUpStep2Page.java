package Page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Configuration.config;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Constants;
import Base.BasePage;

import java.util.Set;

import org.openqa.selenium.*;
import reporting.CustomAssert;

public class SignUpStep2Page extends BasePage{
	
	public SignUpStep2Page() {
		PageFactory.initElements(driver(), this);
	}

	
	@FindBy(xpath = config.selectStandardPlanButton)
	public WebElement selectstandardPlan;
	
	@FindBy(xpath = config.selectPremiunmPlanButton)
	public WebElement selectPremiunPlan;
	
	@FindBy(xpath = config.selectPremiumPlusPlanButton)
	public WebElement selectPremiumPlusPlan;
	
	@FindBy(xpath = config.promoCodeLink)
	public WebElement promoCodeClick;
	
	@FindBy(xpath = config.promoCodeTextBox)
	public WebElement promoCode;
	
	@FindBy(xpath = config.applyButton)
	public WebElement apply;
	
	@FindBy(xpath = config.nameOnCardTextBox)
	public WebElement nameOnCard;
	
	@FindBy(xpath = config.cardNumberTextBox)
	public WebElement cardNumber;
	
	@FindBy(name = config.selectMonthDropDown)
	public WebElement selectMonth;
	
	@FindBy(name = config.selectYearDropDown)
	public WebElement selectYear;
	
	@FindBy(xpath = config.cscTextBox)
	public WebElement csc;
	
	@FindBy(xpath = config.termsCheckBox)
	public WebElement terms;
	
	@FindBy(xpath = config.createMyAccountButton)
	public WebElement createMyAccount;
	
	@FindBy(xpath = config.faqClick1)
	public WebElement faq1;
	
	@FindBy(xpath = config.faqClick2)
	public WebElement faq2;
	
	@FindBy(xpath = config.faqClick3)
	public WebElement faq3;
	
	@FindBy(xpath = config.faqClick4)
	public WebElement faq4;
	
	@FindBy(xpath = config.faqClick5)
	public WebElement faq5;
	
	@FindBy(xpath = config.faqClick6)
	public WebElement faq6;
	
	@FindBy(xpath = config.promoCodeEmptyErrMessage)
	public WebElement promoCodeEmptyError;
	
	@FindBy(xpath = config.nameOnCardEmptyErrMessage)
	public WebElement nameOnCardEmpty;
	
	@FindBy(xpath = config.cardNoEmptyErrMessage)
	public WebElement cardNoEmpty;
	
	@FindBy(xpath = config.monthEmptyErrMessage)
	public WebElement monthEmptyMessage;
	
	@FindBy(xpath = config.yearEmptyErrMessage)
	public WebElement yearEmptyMessage;
	
	@FindBy(xpath = config.cscEmptyErrorMessage)
	public WebElement cscEmptyMessage;
	
	@FindBy(xpath = config.termsNotSelectedErrMessage)
	public WebElement termsNotSelectedMessage;
	
	@FindBy(xpath = config.termsOfServiceLink)
	public WebElement termsOfService;
	
	@FindBy(xpath = config.privacyPolicyLink)
	public WebElement privacyPolicy;
	
	@FindBy(xpath = config.standardPriceText)
	public WebElement standardPrice;
	
	@FindBy(xpath = config.premiumPriceText)
	public WebElement premiumPrice;
	
	@FindBy(xpath =config.premiumPlusPriceText)
	public WebElement premiumPlusPrice;
	
	@FindBy(xpath = config.standardTrialPeriod)
	public WebElement standardTrial;
	
	@FindBy(xpath = config.premiumTrialPeriod)
	public WebElement premiumTrial;
	
	@FindBy(xpath = config.premiumPlusTrialPeriod)
	public WebElement premiumPlusTrial;
	
	
	
	@Step
    public boolean isPageOpened() {
        Boolean promise = isElementPresent(Constants.ELEMENT_30_TIMEOUT_SECONDS, createMyAccount);
        //Attachments.takeScreenshot();
        return promise;
    }
	
	@Step
    public SignUpStep2Page waitForPageToLoad() {
        waitForElementVisibility(createMyAccount);
        return this;
    }
	
	 @Step
	    public SignUpStep2Page checkpromoCodePlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, promoCode)) {
	            try {
	            	promoCode.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing promo code field. Ignoring.");
	            }
	            String expectedText = config.promoCodeSignUp2;
	            String actualText = promoCode.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected promo code field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check promo code input placeholder as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkNameOnCardPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, nameOnCard)) {
	            try {
	            	nameOnCard.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing name on card field. Ignoring.");
	            }
	            String expectedText = config.nameOnCardSignUp2;
	            String actualText = nameOnCard.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected name on card field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check name on card input placeholder as it was not found.");
	        }
	        return this;
	    }
	
	 @Step
	    public SignUpStep2Page checkcardNumberPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, cardNumber)) {
	            try {
	            	cardNumber.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing card number field. Ignoring.");
	            }
	            String expectedText = config.cardNumberSignUp2;
	            String actualText = cardNumber.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected card number field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check card number input placeholder as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkselectMonthPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, selectMonth)) {
	            try {
	            	selectMonth.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing select month field. Ignoring.");
	            }
	            String expectedText = config.selectMonthSignUp2;
	            String actualText = selectMonth.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected select month field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check select month input placeholder as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkselectYearPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, selectYear)) {
	            try {
	            	selectYear.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing select year field. Ignoring.");
	            }
	            String expectedText = config.selectYearSignUp2;
	            String actualText = selectYear.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected select year field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check select year input placeholder as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkcscPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, csc)) {
	            try {
	            	csc.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing csc field. Ignoring.");
	            }
	            String expectedText = config.cscSignUp2;
	            String actualText = csc.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected csc field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check csc input placeholder as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickStandardPlan() {
	        click(selectstandardPlan);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickPremiumPlan() {
	        click(selectPremiunPlan);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickPremiumPlusPlan() {
	        click(selectPremiumPlusPlan);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickHavePromoCodeLink() {
	        click(promoCodeClick);
	        return this;
	    }
	
	 @Step
	    public SignUpStep2Page typePromoCode(String promoCodeInput) {
	       // CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, promoCode), "Can not type promo code as corresponding input was not found.");
	        type(promoCodeInput, promoCode);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickApply() {
	        click(apply);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page typeNameOnCard(String nameOnCardInput) {
	       // CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, nameOnCard), "Can not type name on card as corresponding input was not found.");
	        type(nameOnCardInput, nameOnCard);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page typeCardNumber(String cardNumberInput) {
	       // CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, cardNumber), "Can not type card number as corresponding input was not found.");
	        type(cardNumberInput, cardNumber);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page selectMonth(String monthInput) {
	       // CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, selectMonth), "Can not select month as corresponding input was not found.");
	        Select monthDropdown = new Select(selectMonth);
	        monthDropdown.selectByVisibleText(monthInput);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page selectYear(String yearInput) {
	       // CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, selectYear), "Can not select year as corresponding input was not found.");
	        Select yearDropdown = new Select(selectYear);
	        yearDropdown.selectByVisibleText(yearInput);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page typeCsc(String cscInput) {
	       // CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, csc), "Can not type csc as corresponding input was not found.");
	        type(cscInput, csc);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickTerms() {
	        click(terms);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickcreateMyAccount() {
	        click(createMyAccount);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickFaq1() {
	        click(faq1);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickFaq2() {
	        click(faq2);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickFaq3() {
	        click(faq3);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickFaq4() {
	        click(faq4);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickFaq5() {
	        click(faq5);
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickFaq6() {
	        click(faq6);
	        return this;
	    }
	 
    /* @Step
	    public SignUpStep2Page checkEnteredInfoAndClickPromoCoden(CustomAssert customAssert,String promoCodeEntered, String nameOnCardEntered, String cardNoEntered, String monthEntered, String yearEntered, String cscEntered) {
		 click(promoCodeClick);
		 customAssert.assertEquals(promoCode.getAttribute("value"), promoCodeEntered, "Promo Code input text was not correct.");
		 customAssert.assertEquals(nameOnCard.getAttribute("value"), nameOnCardEntered, "Name On Card input text was not correct.");
		 customAssert.assertEquals(cardNumber.getAttribute("value"), cardNoEntered, "Card Number input text was not correct.");
		 customAssert.assertEquals(cardNumber.getAttribute("value"), cardNoEntered, "Card Number input text was not correct.");
		 customAssert.assertEquals(selectMonth.getAttribute("value"), monthEntered, "Month input text was not correct.");
		 customAssert.assertEquals(selectYear.getAttribute("value"), yearEntered, "Year input text was not correct.");
		 customAssert.assertEquals(csc.getAttribute("value"), cscEntered, "Year input text was not correct.");
		 return this;
	    }*/
	 
	 @Step
	    public SignUpStep2Page checkPromoCodeEmptyErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, promoCodeEmptyError)) {
	            
	            String expectedText = config.promoCodeEmptyMessage;
	            String actualText = promoCodeEmptyError.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected promo code empty error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check name on card empty error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkNameOnCardEmptyErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, nameOnCardEmpty)) {
	            
	            String expectedText = config.nameOnCardEmptyMessage;
	            String actualText = nameOnCardEmpty.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected promo code empty error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check name on card empty error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkCardNoEmptyErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, cardNoEmpty)) {
	            
	            String expectedText = config.cardNoEmptyMessage;
	            String actualText = cardNoEmpty.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected card number empty error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check card number empty error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkMonthErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, monthEmptyMessage)) {
	            
	            String expectedText = config.monthEmptyMessage;
	            String actualText = monthEmptyMessage.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected month empty error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check month empty error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkYearErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, yearEmptyMessage)) {
	            
	            String expectedText = config.yearEmptyMessage;
	            String actualText = yearEmptyMessage.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected year empty error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check year empty error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkCscErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, cscEmptyMessage)) {
	            
	            String expectedText = config.cscEmptyMessage;
	            String actualText = cscEmptyMessage.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected csc empty error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check csc empty error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkTermsNotSelectedErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, termsNotSelectedMessage)) {
	            
	            String expectedText = config.termsNotSelectedMessage;
	            String actualText = termsNotSelectedMessage.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected terms not selected error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check terms not selected error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkTermsAndPrivacyTabOpened(CustomAssert customAssert) {
		 click(termsOfService);
		 click(privacyPolicy);
		 Set<String> handles = driver.getWindowHandles();
		 customAssert.softAssertEqualExpectedActual(String.valueOf(handles.size()), "3", "Terms of Service/Privacy Policy window is not opened.");
		 return this;
	 }
	 
	 @Step
	    public SignUpStep2Page checkStandardPriceAferPromoCode(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, standardPrice)) {
	            
	            String expectedText = config.standardPrice;
	            String actualText = standardPrice.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected Standard Price displayed after applying promo code. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check Standard Price displayed after applying promo code as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkPremiumPriceAferPromoCode(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, premiumPrice)) {
	            
	            String expectedText = config.premiumPrice;
	            String actualText = premiumPrice.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected Premium Price displayed after applying promo code. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check Premium Price displayed after applying promo code as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkPremiumPlusPriceAferPromoCode(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, premiumPlusPrice)) {
	            
	            String expectedText = config.premiumPlusPrice;
	            String actualText = premiumPlusPrice.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected Premium Plus Price displayed after applying promo code. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check Premium Plus Price displayed after applying promo code as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkStandardTrialPeriodAferPromoCode(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, standardTrial)) {
	            
	            String expectedText = config.trialPeriodText;
	            String actualText = standardTrial.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected standard trial period after applying promo code. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check standard trial period after applying promo code as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkPremiumTrialPeriodAferPromoCode(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, premiumTrial)) {
	            
	            String expectedText = config.trialPeriodText;
	            String actualText = premiumTrial.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected premium trial period after applying promo code. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check premium trial period after applying promo code as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpStep2Page checkPremiumPlusTrialPeriodAferPromoCode(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, premiumPlusTrial)) {
	            
	            String expectedText = config.trialPeriodText;
	            String actualText = premiumPlusTrial.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected premium plus trial period after applying promo code. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check premium plus trial period after applying promo code as it was not found.");
	        }
	        return this;
	    }
	 

}
