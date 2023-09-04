package test_Cases;

import org.testng.annotations.Test;
import generic_Utilites.Base;
import generic_Utilites.Excel_Utilites;
import generic_Utilites.External_LocatorsUtility;
import generic_Utilites.Java_Utlities;
import generic_Utilites.WebDriver_Utilities;
import pagesPOM_ObjectRepo.AmazonLandingPage;
import pagesPOM_ObjectRepo.CartPage;
import pagesPOM_ObjectRepo.ProductsListPage;
import pagesPOM_ObjectRepo.SelectedProductPage;
import test_Utility.Sorting_Utility;
/**
 * @author Dibyendu-(DibyenduGithub) Amazon EndtoEnd(Upto AddedCart
 *         Functionality) Testing for a 'Non-Registered User'.s
 */
@Test(dataProviderClass = Excel_Utilites.class, dataProvider = "testData")
public class Amazon_1 extends Base {

	External_LocatorsUtility loc = new External_LocatorsUtility();

	public void AmazonEndtoEnd(String itemName, String quantity) throws Throwable {

		WebDriver_Utilities wlib = new WebDriver_Utilities();
		wlib.WindowMaximize(driver);
		wlib.ImplicitWait(driver);
		// Calling Amazon Landing Page from POM classes
		AmazonLandingPage page1 = new AmazonLandingPage(driver);
		// Searc Product From Landing POM Page
		page1.searchPoduct(itemName);
		Thread.sleep(2000);
		// Selecting matched item from Auto SuggestionList-using Landing POM Page.
		page1.clickItemFromList(driver,itemName);
		// Calling Sorting Utility Method-
		Thread.sleep(1000);
		Sorting_Utility sort = new Sorting_Utility();
		// sorting Price-Low to High
		sort.LowToHigh();
		// Calling Java-Utilities for Scrolling
		Java_Utlities jlib = new Java_Utlities();
		jlib.scrollToBottom();
		jlib.scrollToUp();
		// Sorting Price-High to Low & Other Types
		sort.HighToLow();
		jlib.scrollToBottom();
		jlib.scrollToUp();
		sort.Featured();
		jlib.ProductViewScrollDown();
		// Calling ProductListPage utilites -using ProductListPage POM Page.
		ProductsListPage productListPage = new ProductsListPage(driver);
		// After sorting High to Low-selecting the First item i.e Highest Price
		productListPage.clickFirstItem();
		// Switching to New Window -Product Window -using WebDriver Utility.
		wlib.ProductWindowSwitch(driver);
		jlib.ProductViewScrollDown();
		// Calling Selected ProductPage POM Class
		SelectedProductPage SelectedProductPage = new SelectedProductPage(driver);
		// Click the Main Dispaly Product image from ProductPage POM Class method
		SelectedProductPage.clickProductImage();
		// Individual CatalogImage click from ProductPage POM Class method
		SelectedProductPage.clickCatalog();
		SelectedProductPage.imageBoxClose();
		Thread.sleep(2000);
		// Clicking Add to cart Button
		SelectedProductPage.clickAddtoCart(driver);
		Thread.sleep(3000);
	 //  Clicking ViewCart Button
 	   SelectedProductPage.closeCartsubMenu(driver);
	//	Thread.sleep(3000);
	//	jlib.ProductViewScrollDown();
		// Calling CartPage methods from POM CartPage
	//	CartPage cart = new CartPage(driver);
		// Click quantity DropDown using POM Cart Page Method
	//	Thread.sleep(3000);
	//	cart.clickCartQuantity(driver);
	//	Thread.sleep(3000);
		// select quantity from Excel sheet using POM Cart Page Method
	//	cart.selectQuantity(driver,quantity);
		Thread.sleep(2000);
		page1.clickCartMenu();
		CartPage cart = new CartPage(driver);
		cart.clickCartQuantity(driver);
		cart.selectQuantity(driver,quantity);
	    jlib.ProductViewScrollDown();
		jlib.scrollToUp();
		driver.close();
		// Switching Back to Parent Window-
		wlib.ParentWindowSwitch(driver);
        jlib.scrollToUp();
        // Click HomePage
		page1.clickHomePage();

		System.out.println("Amazon-EndtoEnd-Build-Success");
	}
}