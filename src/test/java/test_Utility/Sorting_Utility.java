package test_Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import generic_Utilites.Base;

public class Sorting_Utility extends Base {
	
	public void LowToHigh() throws Throwable
	{
		WebElement DropdownMenu = driver.findElement(By.cssSelector("[id='s-result-sort-select']"));
		Thread.sleep(2000);
		Select sortDropDown=new Select(DropdownMenu);
		sortDropDown.selectByVisibleText("Price: Low to High");   
		driver.navigate().refresh();
	}
	public void HighToLow() throws Throwable
	{
		WebElement DropdownMenu = driver.findElement(By.cssSelector("[id='s-result-sort-select']"));
		Thread.sleep(2000);
		Select sortDropDown=new Select(DropdownMenu);
		sortDropDown.selectByVisibleText("Price: High to Low");   
		driver.navigate().refresh();
	}
	public void Featured() throws Throwable
	{
		WebElement DropdownMenu = driver.findElement(By.cssSelector("[id='s-result-sort-select']"));
		Thread.sleep(2000);
		Select sortDropDown=new Select(DropdownMenu);
		sortDropDown.selectByVisibleText("Featured");   
		driver.navigate().refresh();
	}
	
	

}
