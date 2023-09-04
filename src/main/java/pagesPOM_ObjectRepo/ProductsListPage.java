package pagesPOM_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage {
	public ProductsListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//img[@class='s-image'][1]")	
private WebElement FirstItem;


public WebElement getFirstItem() {
	return FirstItem;
}	

public void  clickFirstItem()
{
	FirstItem.click();
}

}
