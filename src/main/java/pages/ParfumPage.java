package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import baseSetup.Base;

public class ParfumPage extends Base {

	protected WebDriver driver;

	public ParfumPage(WebDriver driver) {
    super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#autosuggest-form-header > input")

	WebElement SearchBox;

	@FindBy(css= "#autosuggest-form-header > button > span.ico-lens")

	WebElement SearchButton;

	@FindBy(css = "body > div.wrapper.off-canvas-wrap > div.inner-wrap.row-collapse > div > div.content > div.row > aside > div > ul > li.active > ul > li:nth-child(2) > a")

	WebElement Herrenparfum;

	public void InputBrandnameinSearchBox(String brand) {

		Herrenparfum.click();

		SearchBox.sendKeys(brand);

	}

	public SearchResults clickSearchButton() {

		SearchButton.click();
		return new SearchResults(driver);
		
       
	}

	@Override
	public void verifyPageTitle() {

		String pageTitle = driver.findElement(By.xpath("//h1[@class='catalog-headline']")).getText();

		Assert.assertTrue(pageTitle.contains("Parfum"));

	}

}
