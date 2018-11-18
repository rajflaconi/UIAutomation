package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {

	// To take screenshot on failure of test

	private static String source;

	public static String TakeScreenshot(WebDriver driver) {
		final TakesScreenshot ts = (TakesScreenshot) driver;
		source = ts.getScreenshotAs(OutputType.FILE.BASE64);
		return source;
	}

}
