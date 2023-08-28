package pagesPOM_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLandingPage {
	
	// INITIALIZATION
	public AmazonLandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//DECLARATION
@FindBy(id="twotabsearchtextbox")
private WebElement SearchField;






	//GETTER
public WebElement getSearchField() {
	return SearchField;
}
	
	//BUSINESS-LOGIC
	
public void searchPoduct(String itemname)
{
	SearchField.sendKeys(itemname);
}

}
