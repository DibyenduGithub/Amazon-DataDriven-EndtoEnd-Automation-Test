package generic_Utilites;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utilities extends Base {

	public void WindowMaximize(WebDriver wdriver) {

		wdriver.manage().window().maximize();
	}

	public void ImplicitWait(WebDriver wdriver) {

		wdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	public void ElementClick(WebElement ele)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(ele).click().build().perform();
	}
	
	public void ProductWindowSwitch(WebDriver driver) throws Throwable
	{
		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();
        String ParentTitle = driver.getTitle();
		@SuppressWarnings("unused")
		String ParentWindow = it.next();
		System.out.println(ParentTitle);
		Thread.sleep(2000);
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);

	}
	public void ParentWindowSwitch(WebDriver driver)
	{
		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();
		String ParentWindow = it.next();
		driver.switchTo().window(ParentWindow);
	}
	
		
	

}
