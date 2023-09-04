package pagesPOM_ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedProductPage {

	public SelectedProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='imgTagWrapperId']")
	private WebElement productDisplayImage;

	@FindBy(xpath = "//div[@id='ivThumbs']//div[@class='ivRow']//div[@id]")
	private List<WebElement> ProductImageCatalog;

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement ProductImageClose;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement AddToCartButton;

	@FindBy(css = "[class='a-link-normal close-button']")
	private WebElement closeCartsubMenu;

	

	public WebElement getProductDisplayImage() {
		return productDisplayImage;
	}
    public List<WebElement> getProductImageCatalog() {
		return ProductImageCatalog;
	}

	public WebElement getProductImageClose() {
		return ProductImageClose;
	}

	public WebElement getAddToCartButton() {
		return AddToCartButton;
	}

	public WebElement getViewCart() {
		return closeCartsubMenu;
	}

	public void clickProductImage() {
		try {
			productDisplayImage.click();	
		}catch(Exception e)
		{
			System.out.println(e);
		}
}

	public void clickCatalog() throws Throwable {

		for (int i = 1; i < ProductImageCatalog.size(); i++) {
			WebElement ctlgimg = ProductImageCatalog.get(i);
			ctlgimg.click();
			Thread.sleep(1000);
		}
	}

	public void imageBoxClose() {
		try {
			ProductImageClose.click();;	
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void clickAddtoCart(WebDriver driver) throws Throwable {
		try {
		AddToCartButton.click();
		}
		catch(Exception e)
		{
		 
		  System.out.println(e);
		}
	}
	public void closeCartsubMenu(WebDriver driver) {
		try {
			closeCartsubMenu.click();
			}
			catch(Exception e)
			{
			  System.out.println(e);
			}
		
	}

}
