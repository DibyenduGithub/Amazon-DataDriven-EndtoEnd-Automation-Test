package generic_Utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class Java_Utlities extends Base {
	JavascriptExecutor jsy = (JavascriptExecutor) driver;
	WebElement productEnd = driver.findElement(By.cssSelector("[id='p_n_availability-title']"));
	Point productEndLoc = productEnd.getLocation();
	int x = productEndLoc.getX();
	int y = productEndLoc.getY(); 
	
	    public void scrollToBottom() throws Throwable {
		jsy.executeScript("scrollBy(0,350)", "");
		Thread.sleep(1000);
		jsy.executeScript("scrollBy(0,450)", "");
		Thread.sleep(1000);
		jsy.executeScript("scrollBy(0,550)", "");
		Thread.sleep(1000);
		jsy.executeScript("scrollBy(0,650)", "");
		Thread.sleep(1000);
		jsy.executeScript("scrollBy(0,750)", "");
		Thread.sleep(1000);
		jsy.executeScript("scrollBy(0,850)", "");
		Thread.sleep(1000);
		jsy.executeScript("scrollBy(0,"+y +")", "");
		Thread.sleep(2000);
	}

	public void scrollToUp() throws Throwable {
		jsy.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public void ProductViewScrollDown() {
		jsy.executeScript("scrollBy(0,385)", "");
	}
	public void ProductViewScrollUp() {
		jsy.executeScript("scrollBy(0,-350)", "");
	}
	
	public void cartPageScroll()
	{
		WebElement cartPageEnd = driver.findElement(By.cssSelector("[id='sc-subtotal-label-activecart']"));
		Point cartPageEndLoc = cartPageEnd.getLocation();
		int x1 = cartPageEndLoc.getX();
		int y1 = cartPageEndLoc.getY();
		jsy.executeScript("scrollBy("+x1+","+y1 +")", "");
	}
}
