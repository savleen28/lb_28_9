package Page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Configuration.config;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Constants;
import Base.BasePage;
import org.openqa.selenium.*;
import reporting.CustomAssert;

public class SignUpPage1 extends BasePage  {
	
	/*WebDriver driver;                            

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}*/
	
	public SignUpPage1() {
		PageFactory.initElements(driver(), this);
	}
	
	
	@FindBy(className = config.nextStepButton)
	public WebElement nextStep;
	
	@FindBy(xpath = config.signInButtonTrialPageButton)
	public WebElement signIn;
	
	@FindBy(xpath = config.emailSignUpTextBox)
	public WebElement email;
	
	@FindBy(xpath = config.passwordSignUpTextBox)
	public WebElement password;
	
	@FindBy(xpath = config.showHidepwdCheckBoxSignUp)
	public WebElement showHidepwdCheckBox;
	
	@FindBy(xpath = config.firstNameTextBox)
	public WebElement firstName;
	
	@FindBy(xpath = config.lastNameTextBox)
	public WebElement lastName;
	
	@FindBy(xpath = config.companyNameTextBox)
	public WebElement companyName;
	
	@FindBy(xpath = config.phoneNumberTextBox)
	public WebElement phoneNumber;
	
	@FindBy(xpath = config.welcomeBackMessage)
	public WebElement welcomeBack;
	
	@FindBy(xpath = config.emailErrorMessage)
	public WebElement emailRequired;
	
	@FindBy(xpath = config.passwordErrorMessage)
	public WebElement passwordRequired;
	
	@FindBy(xpath = config.firstNameErrorMessage)
	public WebElement firstNameRequired;
	
	@FindBy(xpath = config.lastNameErrorMessage)
	public WebElement lastNameRequired;
	
	@FindBy(xpath = config.phoneNoErrorMessage)
	public WebElement phoneNoRequired;
	
   //BasePage basePage = PageFactory.initElements(driver, BasePage.class);

	@Step
	public boolean isPageOpened() {
		Boolean promise = isElementPresent(Constants.ELEMENT_30_TIMEOUT_SECONDS, nextStep);
		// Attachments.takeScreenshot();
		return promise;
	}
	 
	@Step
	public SignUpPage1 waitForPageToLoad() {
		waitForElementVisibility(nextStep);
		return this;
	}
	 
	 @Step
	    public SignInPage nextStepButton() {
	       click(signIn);
	        return PageFactory.initElements(driver(), SignInPage.class);
	    }
	 
	 @Step
	    public SignUpPage1 checkEmailInputPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, email)) {
	            try {
	            	email.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing email field. Ignoring.");
	            }
	            String expectedText = config.emailSignUp;
	            String actualText = email.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected email field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check Email input placeholder as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 checkPasswordInputPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, password)) {
	            try {
	            	password.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing password field. Ignoring.");
	            }
	            String expectedText = config.passwordSignUp;
	            String actualText = password.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected password field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check password input placeholder as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 checkFirstNameInputPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, firstName)) {
	            try {
	            	firstName.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing first name field. Ignoring.");
	            }
	            String expectedText = config.firstNameSignUp;
	            String actualText = firstName.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected first name field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check first name input placeholder as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 checkLastNameInputPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, lastName)) {
	            try {
	            	lastName.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing last name field. Ignoring.");
	            }
	            String expectedText = config.lastNameSignUp;
	            String actualText = lastName.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected last name field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check last name input placeholder as it was not found.");
	        }
	        return this;
	    }


	 @Step
	    public SignUpPage1 checkCompanyNameInputPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, companyName)) {
	            try {
	            	companyName.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing company name field. Ignoring.");
	            }
	            String expectedText = config.companyNameSignUp;
	            String actualText = companyName.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected company name field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check company name input placeholder as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 checkPhoneNumberInputPlaceholder(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, phoneNumber)) {
	            try {
	            	phoneNumber.clear();
	            } catch (WebDriverException wde) {
	                System.err.println("Catching error during clearing phone number field. Ignoring.");
	            }
	            String expectedText = config.phoneNumberSignUp;
	            String actualText = phoneNumber.getAttribute("placeholder");
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected phone number field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check phone number input placeholder as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 typeEmail(String emailInput) {
	        CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, email), "Can not type email as corresponding input was not found.");
	        email.clear();
	        type(emailInput, email);
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 typePassword(String passwordInput) {
	        CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, password), "Can not type password as corresponding input was not found.");
	        password.clear();
	        type(passwordInput, password);
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 typeFirstName(String firstNameInput) {
	       CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, firstName), "Can not type first name as corresponding input was not found.");
	       firstName.clear();
	        type(firstNameInput, firstName);
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 typeLastName(String lastNameInput) {
	        CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, lastName), "Can not type last name as corresponding input was not found.");
	        lastName.clear();
	        type(lastNameInput, lastName);
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 typeCompanyName(String companyNameInput) {
	       CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, companyName), "Can not type company name as corresponding input was not found.");
	       companyName.clear();
	        type(companyNameInput, companyName);
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 typePhoneNumber(String phoneNumberInput) {
	        CustomAssert.hardAssertTrue(isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, phoneNumber), "Can not type company name as corresponding input was not found.");
	        phoneNumber.clear();
	        type(phoneNumberInput, phoneNumber);
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 clickShowPassword() {
	        click(showHidepwdCheckBox);
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 checkEnteredInfoAndHidePasswordButton(CustomAssert customAssert,String emailEntered, String passwordEntered, String firstNameEntered, String lastNameEntered, String companyNameEntered, String phoneEntered) {
		 customAssert.assertEquals(email.getAttribute("value"), emailEntered, "Email input text was not correct.");
		 customAssert.assertEquals(password.getAttribute("value"), passwordEntered, "Password input text was not correct.");
		 customAssert.assertEquals(password.getAttribute("type"), "password", "Password input text was not hidden.");
		 click(showHidepwdCheckBox);
		 customAssert.assertEquals(firstName.getAttribute("value"), firstNameEntered, "First name input text was not correct.");  
		 customAssert.assertEquals(lastName.getAttribute("value"), lastNameEntered, "Last name input text was not correct.");
		 customAssert.assertEquals(phoneNumber.getAttribute("value").replaceAll("[\\s()-]", ""), phoneEntered, "Phone input text was not correct.");
		 return this;
	    }
	 
	 @Step
	    public SignUpStep2Page clickSignUpButton() {
	      click(nextStep);
	      return PageFactory.initElements(driver(), SignUpStep2Page.class);
	    }
	 
	 @Step
	    public SignUpPage1 checkEmailRequiredErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, emailRequired)) {
	            
	            String expectedText = config.emailRequiredMessage;
	            String actualText = emailRequired.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected email error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check email error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 checkPasswordRequiredErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, passwordRequired)) {
	            
	            String expectedText = config.passwordRequiredMessage;
	            String actualText = passwordRequired.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected password error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check password error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 checkFirstNameRequiredErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, firstNameRequired)) {
	            
	            String expectedText = config.firstNameRequiredMessage;
	            String actualText = firstNameRequired.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected first name error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check first name error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 checkLastNameRequiredErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, lastNameRequired)) {
	            
	            String expectedText = config.lastNameRequiredMessage;
	            String actualText = lastNameRequired.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected last name error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check last name error message as it was not found.");
	        }
	        return this;
	    }
	 
	 @Step
	    public SignUpPage1 checkPhoneNoNameRequiredErrorMessage(CustomAssert customAssert) {
	       
	        if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, phoneNoRequired)) {
	            
	            String expectedText = config.phoneNumberRequiredMessage;
	            String actualText = phoneNoRequired.getText();
	            customAssert.softAssertTrue(expectedText.equals(actualText),
	                    "Unexpected phone number error message. Expected: '" + expectedText + "'. Actual: '" + actualText + "'.");
	        } else {
	            customAssert.fail("Can not check phone number error message as it was not found.");
	        }
	        return this;
	    }

}

