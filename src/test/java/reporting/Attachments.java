package reporting;

import properties.Properties;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Attachments {
	
	@Attachment(value = "Passed parameters.", type = "text/plain")
	public static String attachPassedParameters() {
		String browser = Properties.getBrowser();
		return "browser: " + browser;
	}

}
