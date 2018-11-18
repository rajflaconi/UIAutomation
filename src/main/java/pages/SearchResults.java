package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseSetup.Base;
import utility.PropertyFileReader;

public class SearchResults extends Base {

	protected WebDriver driver;

	public SearchResults(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='product-description']/img")

	public WebElement Product;
	public String productname;

	@Override
	public void verifyPageTitle() {

		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='dior-logo']")).isDisplayed());

	}

	public AddtoCart clickonProduct() {
		deleteCookies();

		productname = driver
				.findElement(By.cssSelector(
						"div.item.medium-4.small-6.columns.slick-slide.slick-current.slick-active>a>div.series"))
				.getText();
		PropertyFileReader.setvalue("ActualProductName", productname);

		Product.click();

		return new AddtoCart(driver);

	}

	public void deleteCookies() {

		driver.manage().deleteAllCookies();
	}

}
