package pagesPOM_ObjectRepo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonLandingPage {
	
	
	// INITIALIZATION
	public AmazonLandingPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	//DECLARATION
@FindBy(id="twotabsearchtextbox")
private WebElement SearchField;

@FindBy(css="[class='s-suggestion-container']")
private List<WebElement> productSuggestionList;

@FindBy(xpath="//div[@id='nav-cart-text-container']//span[@class='nav-line-2']")
private WebElement cart;

@FindBy(css="[aria-label='Amazon.in']")
private WebElement Homepage;

//GETTER
public WebElement getSearchField() {
	return SearchField;
}
public List<WebElement> getProductSuggestionList() {
	return productSuggestionList;
}

public WebElement getCart() {
	return cart;
}
public WebElement getHomepage() {
	return Homepage;
}

	//BUSINESS-LOGIC
	

public void searchPoduct(String itemname)
{
	SearchField.sendKeys(itemname);
}
public  void clickItemFromList(WebDriver driver,String itemName)
{
	
	for(WebElement a:productSuggestionList)
	{
		if(a.getText().equalsIgnoreCase(itemName))
		{
		a.click();   
		break;
		}
		else 
		{
		a.click();   
		break;
		}
	/*
		else
		{
			a.sendKeys(Keys.ARROW_DOWN);
			a.sendKeys(Keys.ENTER);
			break;
		}
	*/
	}	}

public void clickCartMenu(){
	cart.click();
}


public void clickHomePage()
{
	Homepage.click();
}
}

