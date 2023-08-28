package test_Cases;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic_Utilites.Base;
import generic_Utilites.Excel_Utilites;
import generic_Utilites.WebDriver_Utilities;
import pagesPOM_ObjectRepo.AmazonLandingPage;

/**@author Dibyendu-(DibyenduGithub)
 * Amazon EndtoEnd(Upto AddedCart Functionality) Testing for a 'Non-Registered User'.
 * 
 *
 */
@Test(dataProviderClass = Excel_Utilites.class, dataProvider = "testData")
public class Amazon_1 extends Base {

	public void AmazonEndtoEnd(String itemName,String quantity) throws Throwable {

		WebDriver_Utilities wlib = new WebDriver_Utilities();
        wlib.WindowMaximize(driver);

        AmazonLandingPage page1 = new AmazonLandingPage(driver);
		page1.searchPoduct(itemName);
		//wlib.ImplicitWait(driver);
		Thread.sleep(2000);

		List<WebElement> AllSuggestions = driver
				.findElements(By.xpath("//div[@class='autocomplete-results-container']//div[@aria-label]"));

		for (WebElement e : AllSuggestions) {
			if (e.getText().equals(itemName)) {
				e.click();
				break;
				}
			}
		Thread.sleep(3000);
		WebElement scrollupto = driver.findElement(By.xpath("//span[contains(text(),'Eligible for Pay On Delivery')]"));

		int x = wlib.getXAxis(driver, scrollupto);
		int y = wlib.getYAxix(driver, scrollupto);
		wlib.JavaScriptScroll(x, y, driver);
		
		Thread.sleep(3000);

		WebElement Choice = driver.findElement(
				By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']//img[@data-image-index='3']"));
		String ActualChoice = Choice.getText();
		Choice.click();
		wlib.ImplicitWait(driver);
	//	Thread.sleep(3000);

		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();

		String ParentTitle = driver.getTitle();
		@SuppressWarnings("unused")
		String ParentWindow = it.next();
		System.out.println(ParentTitle);
		wlib.ImplicitWait(driver);
		//Thread.sleep(2000);
		String ChildWindow = it.next();

		driver.switchTo().window(ChildWindow);
		String ChildTitle = driver.getTitle();
		System.out.println(ChildTitle);

		wlib.NormalScroll(driver);
		wlib.ImplicitWait(driver);
		// Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id=\"imgTagWrapperId\"]")).click();
		
		 Thread.sleep(3000);

		// Individual CatalogImage click

		List<WebElement> catalogs = driver
				.findElements(By.xpath("//div[@id=\"ivThumbs\"]//div[@class=\"ivRow\"]//div[@id]"));

		for (int i = 1; i < catalogs.size(); i++) 
		    {
			WebElement ctlgimg = catalogs.get(i);
			ctlgimg.click();
			Thread.sleep(3000);
			}
		wlib.ImplicitWait(driver);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		Thread.sleep(4000);
		// driver.findElement(By.id("id=\"add-to-cart-button\"")).click();

		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//span[@class='a-button-inner']//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce'] "))
				.click();

		wlib.ImplicitWait(driver);
		//Thread.sleep(2000);
		wlib.NormalScroll(driver);
		String cartItem = driver.findElement(By.xpath("//span[@class='a-truncate-full a-offscreen']")).getText();
		Assert.assertEquals(cartItem, ActualChoice);
		driver.findElement(By.xpath("//span[@class='a-dropdown-label']")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//a[@id='quantity_2']")).click();
		
		List<WebElement> quantityList = driver.findElements(By.xpath("//li[@class=\'a-dropdown-item quantity-option']/a[@id]"));
		for (WebElement e:quantityList)
		{
			if(e.getText().contains(quantity))
			{
				e.click();
				break;
			}
		}
		Thread.sleep(6000);
	

		System.out.println("SUccess");
	}
}