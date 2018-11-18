package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddtoCart;
import pages.CartBasket;
import pages.Homepage;
import pages.ParfumPage;
import pages.SearchResults;
import utility.PropertyFileReader;

public class BuyPerfumeTest extends BaseTest {

	
	@Test(priority = 1)
	public void buyPerfumeTest() {

		Homepage homepage = new Homepage(driver);

		homepage.clickPerfume();
		homepage.verifyPageTitle();

		ParfumPage perfumpage = new ParfumPage(driver);
		perfumpage.InputBrandnameinSearchBox(PropertyFileReader.getString("brand"));

		SearchResults searchresult = perfumpage.clickSearchButton();

		AddtoCart addcart = searchresult.clickonProduct();
		addcart.clickAddtoCart();

		CartBasket cartbasket = addcart.openCart();

		cartbasket.verifyProductInCart();

	}

	@Test(priority = 2)
	public void buyPerfumeTestFailureScreenshot() {

		Homepage homepage = new Homepage(driver);

		homepage.clickPerfume();
		homepage.verifyPageTitle();

		// To make the test fail and take screenshot
		Assert.assertEquals(true, false);

	}
}