package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.PropertyFileReader;

public class CartBasket {

	protected WebDriver driver;
	
	
	
	CartBasket(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//PageFactory pattern to load and initialize elements
	
	@FindBy(css="div.columns.medium-10.small-8 > div > div.columns.small-12.medium-6.gap-margin > div > strong > a")
	public WebElement cartproduct;
	
	public void verifyProductInCart() {
		
		Assert.assertTrue(cartproduct.getText().toLowerCase().contains(PropertyFileReader.getString("ActualProductName")));
		System.out.println(cartproduct.getText().toLowerCase());
	}
}
