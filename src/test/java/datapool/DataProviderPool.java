package datapool;

import org.testng.annotations.DataProvider;

public class DataProviderPool {
	 // Constants must match the name attributes for <credentials/> tags in datapool.xml

    public static final String PREMIUM_CREDENTIALS = "premiumCredentials";
    public static final String PC_MILER_CREDENTIALS = "pcMilerCredentials";
    public static final String RATE_CHECK_CREDENTIALS = "rateCheckCredentials";
    public static final String NO_ADDON_CREDENTIALS = "noAddonCredentials";
    public static final String VERIFIED_CREDENTIALS = "verifiedCredentials";
    public static final String PROFILE_EMAIL_CREDENTIALS = "profileEmailCredentials";

    private static DataPoolReader reader = new DataPoolReader();

    @DataProvider(name = PREMIUM_CREDENTIALS)
    public static Object[][] getPremiumCredentials() {
        return reader.GetCredentials(PREMIUM_CREDENTIALS);
    }

    @DataProvider(name = PC_MILER_CREDENTIALS)
    public static Object[][] getPcMilerCredentials() {
        return reader.GetCredentials(PC_MILER_CREDENTIALS);
    }

    @DataProvider(name = RATE_CHECK_CREDENTIALS)
    public static Object[][] getRateCheckCredentials() {
        return reader.GetCredentials(RATE_CHECK_CREDENTIALS);
    }

    @DataProvider(name = NO_ADDON_CREDENTIALS)
    public static Object[][] getNoAddonCredentials() {
        return reader.GetCredentials(NO_ADDON_CREDENTIALS);
    }

    @DataProvider(name = VERIFIED_CREDENTIALS)
    public static Object[][] getVerifiedCredentials() {
        return reader.GetCredentials(VERIFIED_CREDENTIALS);
    }

    @DataProvider(name = PROFILE_EMAIL_CREDENTIALS)
    public static Object[][] getProfileEmailCredentials() {
        return reader.GetCredentials(PROFILE_EMAIL_CREDENTIALS);
    }
}