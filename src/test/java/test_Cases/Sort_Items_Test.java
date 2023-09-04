package test_Cases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Sort_Items_Test {

	public static WebDriver driver;
	@Test
	public void sortList() throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.navigate().refresh();
	//	driver.navigate().refresh();
	//	driver.navigate().refresh();
	//	driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		
		 driver.findElement(By.cssSelector("[aria-label='mobile']")).click();
		
		
		WebElement DropdownMenu = driver.findElement(By.cssSelector("[id='s-result-sort-select']"));
		Thread.sleep(3000);
		Select sortDropDown=new Select(DropdownMenu);
		sortDropDown.selectByVisibleText("Price: Low to High");   
		driver.navigate().refresh();
		JavascriptExecutor jsy=(JavascriptExecutor)driver;
		jsy.executeScript("scrollBy(0,450)","");
		
		Thread.sleep(4000);
		
		WebElement FirstItem = driver.findElement(By.xpath("//div[@class='a-section']//div[@class='a-section a-spacing-small a-spacing-top-small']//h2//a//span[@class='a-size-medium a-color-base a-text-normal'][1]"));
		
		a.moveToElement(FirstItem).click().build().perform();
		
		
		

		
	
		
	}
	
	
	
}
