package pagesPOM_ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
 public CartPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(xpath="//span[@class='a-dropdown-label']")
 private WebElement QuantityDropdown;
 
 @FindBy(xpath="//li[@class='a-dropdown-item quantity-option']/a[@id]")
 private List<WebElement> quantityList;

 @FindBy(css="[aria-label='Amazon.in']")
 private WebElement Homepage;

public WebElement getQuantityDropdown() {
	return QuantityDropdown;
}
public List<WebElement> getQuantityList() {
	return quantityList;
}
public WebElement getHomepage() {
	return Homepage;
}


public void clickCartQuantity(WebDriver driver)
 {
	try {
		QuantityDropdown.click(); 
		}
		catch(Exception e)
		{
		System.out.println(e);
		} 
	 }
 
 public void selectQuantity(WebDriver driver,String quantty) throws Throwable 
 {
	 try { 
		 for (WebElement e : quantityList) {
			if (e.getText().contains(quantty)) {
				e.click();
				Thread.sleep(4000);
				break;
			} } 
		 }
			catch(Exception e)
			{
				  System.out.println(e);
			} 
}}

