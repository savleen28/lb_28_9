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
	public static final String incorrectEmailErrorMessage = "//*[@id=\"form\"]/div";
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
	//SignUpStep2Page
	public static final String selectStandardPlanButton = "//*[@id=\"plansContainer\"]/section/div/div[1]/div[1]/div/a[1]";
	public static final String selectPremiunmPlanButton ="//*[@id=\"plansContainer\"]/section/div/div[1]/div[2]/div/ul";
	public static final String selectPremiumPlusPlanButton = "//*[@id=\"plansContainer\"]/section/div/div[1]/div[3]/div/a[1]";
	public static final String promoCodeLink = "//*[@id=\"plansform\"]/div[1]/div/div[2]/a";
	public static final String promoCodeTextBox = "//*[@id=\"promocode\"]";
	public static final String applyButton = "//*[@id=\"plansform\"]/div[2]/section/input[5]"; 
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
	public static final String resendEmailText = "//div[@class='resend-message valid']/p";
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
	
	
	
	
	
	
	

}
