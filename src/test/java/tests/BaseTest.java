package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import baseSetup.DriverManager;

public class BaseTest {

	
	
	
	public static WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {
        this.driver = DriverManager.getDriverInstance();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
	
	
}
