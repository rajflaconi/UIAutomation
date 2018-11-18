package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseSetup.Base;

public class Homepage extends Base {

	protected WebDriver driver;

	public Homepage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will initialize WebElements in current page

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//header//a[text()='Parfum'][@data-webtrekk-link-id='header.nav']")

	public WebElement Parfum;

	@FindBy(xpath = "//a[@class='cookie-box__close']/span")
	public WebElement cookie;

	public void clickPerfume() {

		if (cookie.isDisplayed())
			cookie.click();
		;
		Parfum.click();

	}

	// overridden method from Base class
	@Override
	public void verifyPageTitle() {

		driver.findElement(By.xpath("//a[@title='Flaconi Online-Parfümerie']"));
	}

}
