package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCart {

	protected WebDriver driver;

	AddtoCart(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory pattern to load and initialize elements

	@FindBy(xpath = "//*[@class=\"product-list\"]/li/div/form/button")
	public WebElement Addtocart;

	@FindBy(css = "#htmlData > div.footer.row > div > a")
	public WebElement closeCart;

	@FindBy(xpath = "//span[@class='ico-basket']")
	public WebElement Cart;

	public void clickAddtoCart() {
		Addtocart.click();
	}

	public CartBasket openCart() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOf(closeCart));

		closeCart.click();

		return new CartBasket(driver);

	}
}
