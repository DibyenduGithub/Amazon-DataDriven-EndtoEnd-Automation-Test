package generic_Utilites;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriver_Utilities extends Base {

	public void WindowMaximize(WebDriver wdriver) {

		wdriver.manage().window().maximize();
	}

	public void ImplicitWait(WebDriver wdriver) {

		wdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}

	
	
	public int getXAxis(WebDriver driver,WebElement scrollupto)
	{
		 Point scrollLocation = scrollupto.getLocation();
		 int x=scrollLocation.getX();
		 return x;
	
	}
	public int getYAxix(WebDriver driver,WebElement scrollupto)
	{
		 Point scrollLocation = scrollupto.getLocation();
		 int y=scrollLocation.getY();
		 return y;
	
	}
	
	public void JavaScriptScroll(int x,int y,WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public void NormalScroll(WebDriver driver)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,250)","");
	}
	
	

}
