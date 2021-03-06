package Configuration;



public class config {
	public static String testsite = "https://www.dev.123loadboard.com/find-loads/";
	//SignIn
	public static final String signIn= "submit";
	public static final String showHidePasswordCheckBox = "//*[@id=\"signup-showpassword\"]";
	public static final String email ="//*[@id=\"signin\"]/input[1]";
	public static final String password = "//*[@id=\"signin\"]/input[2]";
	public static final String rememberMeCheckBox = "//*[@id=\"remember\"]";
	public static final String forgotPasswordLink = "//*[@id=\"form\"]/a";
	public static final String signUpLink = "lb-link";
	public static final String incorrectEmailErrorMessage = "//*[@id=\"main\"]/section/div/form/div";
	public static final String myAccountLink = "//*[@id=\"top-menu\"]/li[5]/a";
	//Start Page
	public static final String signInButton = "Sign in";
	public static final String trialButton = "//*[@id=\"main-menu\"]/li[7]/a";
	//SignUpPage
	public static final String nextStepButton = "btn--submit";
	public static final String signInButtonTrialPageButton = "//*[@id=\"signup\"]/div/aside[1]/a";
	public static final String emailSignUpTextBox = "//*[@id=\"emailVerification\"]";
	public static final String passwordSignUpTextBox = "//*[@id=\"signup--forms\"]/form/section[1]/input[2]";
	public static final String showHidepwdCheckBoxSignUp = "//*[@id=\"signup-showpassword\"]";
	public static final String firstNameTextBox = "//*[@id=\"signup--forms\"]/form/section[3]/input[1]";
	public static final String lastNameTextBox = "//*[@id=\"signup--forms\"]/form/section[3]/input[2]";
	public static final String companyNameTextBox = "//*[@id=\"signup--forms\"]/form/section[3]/input[3]";
	public static final String phoneNumberTextBox = "//*[@id=\"signup--forms\"]/form/section[3]/input[4]";
	public static final String welcomeBackMessage = "//*[@id=\"duplicate-email\"]/h3";
	public static final String emailErrorMessage = "//*[@id=\"signup--forms\"]/form/section[1]/div[1]";
	public static final String passwordErrorMessage = "//*[@id=\"signup--forms\"]/form/section[1]/div[2]";
	public static final String emailAlreadyInUseErrMessage = "//*[@id=\"signup--forms\"]/section/ul/li";
	
	public static final String firstNameErrorMessage = "//*[@id=\"signup--forms\"]/form/section[3]/div[1]";
	public static final String lastNameErrorMessage = "//*[@id=\"signup--forms\"]/form/section[3]/div[2]";
	public static final String phoneNoErrorMessage = "//*[@id=\"signup--forms\"]/form/section[3]/div[3]";
	//SignUpStep2Page
	public static final String selectStandardPlanButton = "//*[@id=\"plansContainer\"]/section/div/div[1]/div[1]/div/a[1]";
	public static final String selectPremiunmPlanButton ="//*[@id=\"plansContainer\"]/section/div/div[1]/div[2]/div/ul";
	public static final String selectPremiumPlusPlanButton = "//*[@id=\"plansContainer\"]/section/div/div[1]/div[3]/div/a[1]";
	public static final String promoCodeLink = "//*[@id=\"plansform\"]/div[1]/div/div[2]/a";
	public static final String promoCodeTextBox = "//*[@id=\"promocode\"]";
	public static final String applyButton = "//*[@id=\"promoButton\"]";  
	public static final String nameOnCardTextBox = "//*[@id=\"plansform\"]/div[2]/section/input[1]";
	public static final String cardNumberTextBox = "//*[@id=\"plansform\"]/div[2]/section/input[2]";
	public static final String selectMonthDropDown = "ccexpirityMonth";
	public static final String selectYearDropDown = "ccexpirityYear";
	public static final String cscTextBox = "//*[@id=\"plansform\"]/div[2]/section/input[3]";
	public static final String termsCheckBox = "//*[@id=\"signup-acceptterms\"]";
	public static final String createMyAccountButton = "//*[@id=\"plansform\"]/div[2]/section/input[5]";
	public static final String faqClick1 = "//*[@id=\"plansform\"]/div[2]/section/ul[2]/li[1]/a";
	public static final String faqClick2 = "//*[@id=\"plansform\"]/div[2]/section/ul[2]/li[2]/a";
	public static final String faqClick3 = "//*[@id=\"plansform\"]/div[2]/section/ul[2]/li[3]/a";
	public static final String faqClick4 = "//*[@id=\"plansform\"]/div[2]/section/ul[2]/li[4]/a";
	public static final String faqClick5 = "//*[@id=\"plansform\"]/div[2]/section/ul[2]/li[5]/a";
	public static final String faqClick6 = "//*[@id=\"plansform\"]/div[2]/section/ul[2]/li[6]/a";
	public static final String promoCodeEmptyErrMessage = "//*[@id=\"empty-error\"]";
	public static final String nameOnCardEmptyErrMessage = "//*[@id=\"plansform\"]/div[2]/section/div[1]";
	public static final String cardNoEmptyErrMessage = "//*[@id=\"plansform\"]/div[2]/section/div[2]";
	public static final String monthEmptyErrMessage ="//*[@id=\"plansform\"]/div[2]/section/div[3]/div[1]/div";
	public static final String yearEmptyErrMessage = "//*[@id=\"plansform\"]/div[2]/section/div[3]/div[2]/div";
	public static final String cscEmptyErrorMessage = "//*[@id=\"plansform\"]/div[2]/section/div[4]";  
	public static final String termsNotSelectedErrMessage = "//*[@id=\"plansform\"]/div[2]/section/div[5]";
	public static final String termsOfServiceLink = "//*[@id=\"plansform\"]/div[2]/section/label[5]/a[1]";
	public static final String privacyPolicyLink = "//*[@id=\"plansform\"]/div[2]/section/label[5]/a[2]";
	public static final String standardPriceText = "//*[@id=\"plansContainer\"]/section/div/div[1]/div[1]/div/span[2]";
	public static final String premiumPriceText = "//*[@id=\"plansContainer\"]/section/div/div[1]/div[2]/div/span[2]";
	public static final String premiumPlusPriceText = "//*[@id=\"plansContainer\"]/section/div/div[1]/div[3]/div/span[2]";
	public static final String standardTrialPeriod = "//*[@id=\"plansContainer\"]/section/div/div[1]/div[1]/div/span[4]";
	public static final String premiumTrialPeriod = "//*[@id=\"plansContainer\"]/section/div/div[1]/div[2]/div/span[4]";
	public static final String premiumPlusTrialPeriod = "//*[@id=\"plansContainer\"]/section/div/div[1]/div[3]/div/span[4]";
	//Placeholders for SignUpPage
	public static final String emailSignUp ="Email Address";
	public static final String passwordSignUp ="Password (min. 6 characters)";
	public static final String firstNameSignUp ="First Name";
	public static final String lastNameSignUp ="Last Name";
	public static final String companyNameSignUp ="Company Name (optional)";
	public static final String phoneNumberSignUp ="Phone Number";
	//Placeholders for SignUpStep2Page page
	public static final String promoCodeSignUp2 = "Promo Code (optional)";
	public static final String nameOnCardSignUp2 = "Name on Card";
	public static final String cardNumberSignUp2 = "Card Number";
	public static final String selectMonthSignUp2 = "Select Month";
	public static final String selectYearSignUp2 = "Select Year";
	public static final String cscSignUp2 = "Card Security Code (CSC)";
	//Confirmation Page
	public static final String confMessageText = "//div[@class='signup--forms']/p";
	public static final String updateEmailLink = "//*[@id=\"signup--resendemail-togglebtn\"]";
	public static final String resendEmailLink = "//*[@id=\"signup--forms\"]/form[2]/p/a";
	public static final String resendEmailText = "//*[@id=\"signup--forms\"]/p[2]"; 
	public static final String updateEmailTextBox = "//*[@id=\"signup--forms\"]/form[1]/div/input[1]";
	public static final String updateEmailButton = "//*[@id=\"signup--forms\"]/form[1]/div/input[2]";
	public static final String updateEmailText = "//div[@class='resend-message valid']/p";
	//ForgotPasswordPage
	public static final String resetPasswordButton = "//*[@id=\"main\"]/section/div/form/input[2]";
	public static final String resetEmailTextBox = "//*[@id=\"main\"]/section/div/form/input[1]";
	public static final String resetPasswordInstructions = "//*[@id=\"main\"]/section/div/div/p[2]";  
	public static final String invalidEmailErrorMessage = "//*[@id=\"main\"]/section/div/form/div";
	//HomePage
	public static final String unverifiedAccountMessage = "//*[@id=\"Content\"]/div[1]/div[2]";
	public static final String logoutDropdown = "//*[@id=\"topAccountMenu\"]/div[1]";
	public static final String logoutButton = "//*[@id=\"divAccountPopup\"]/div/ul/li[4]";
	public static final String loadSearchLink = "//*[@id=\"divDashboard\"]/a[1]/span[1]";
	//SignUpPage Error Messages
	public static final String emailRequiredMessage = "Email Address is required";
	public static final String passwordRequiredMessage = "Password (min. 6 characters) is required";
	public static final String firstNameRequiredMessage = "First Name is required";
	public static final String lastNameRequiredMessage = "Last Name is required";
	public static final String phoneNumberRequiredMessage = "Phone Number is not valid";
	public static final String emailAlreadyInUseMessage = "Email already in use";
	public static final String promoCodeEmptyMessage = "Please enter a promo code";
	public static final String nameOnCardEmptyMessage ="Name on Card is required";
	public static final String cardNoEmptyMessage ="Credit card is not valid";
	public static final String monthEmptyMessage ="Select Month is required";
	public static final String yearEmptyMessage ="Select Year is required";
	public static final String cscEmptyMessage ="Card Security Code (CSC) is not valid";
	public static final String termsNotSelectedMessage = "Click the checkbox to accept terms of service";
	//Price of the plans after applying promo code on sign up step 2 page
	public static final String standardPrice = "25";
	public static final String premiumPrice = "30";
	public static final String premiumPlusPrice = "35";
	public static final String trialPeriodText = "30 day free trial included";
	
	
	
	
	
	
	
	
	
	

}
