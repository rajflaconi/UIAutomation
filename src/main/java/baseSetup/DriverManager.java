package baseSetup;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import utility.PropertyFileReader;

public class DriverManager {

	public static WebDriver driver;

	// To instantiate the appropriate browser based on current platform
	public static WebDriver getDriverInstance() throws IOException {

		PropertyFileReader.loadPropertyFile();
		String browser = System.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			String operatingSystem = System.getProperty("os.name").toLowerCase();
			if (operatingSystem.contains("win")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
				driver = new ChromeDriver();

			}
			if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver");
				driver = new ChromeDriver();

			}
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		navigateAndMaximize();
		return driver;
	}

	// navigate to url and maximize the window
	public static void navigateAndMaximize() {

		driver.manage().deleteAllCookies();
		driver.get(PropertyFileReader.getString("URL"));
		driver.manage().window().maximize();
	}

}
