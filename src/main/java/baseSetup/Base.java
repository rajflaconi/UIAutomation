package baseSetup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.PropertyFileReader;


public abstract class Base {

	//force all child classes to implement this method
	public abstract void verifyPageTitle();
    

}
