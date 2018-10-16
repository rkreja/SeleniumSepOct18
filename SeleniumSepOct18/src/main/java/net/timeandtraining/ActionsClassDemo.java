package net.timeandtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.automationpractice.framework.TestBase;

public class ActionsClassDemo extends TestBase{
	
	
	
	@Test
	public void mouseOverByActionsClass() {
		
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		
		Actions actions = new Actions(driver);
		WebElement red = driver.findElement(By.xpath("(//li)[1]"));
		WebElement green = driver.findElement(By.xpath("(//li)[2]"));
		WebElement blue = driver.findElement(By.xpath("(//li)[3]"));
		
		
		
		actions.moveToElement(green).build().perform();
		actions.moveToElement(red).build().perform();
		actions.moveToElement(blue).build().perform();
		
		
		
		
	}
	
	
	@Test
	public void dragAndDropActionsClass() {
		
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		
		Actions actions = new Actions(driver);
		WebElement logo=driver.findElement(By.id("drag"));
		WebElement target=driver.findElement(By.id("drop"));
		
		actions.dragAndDrop(logo, target).build().perform();
	
		
		
		
	}
	
	@Test
	public void scrollUsingActionsClass() {
		
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		
		Actions actions = new Actions(driver);
		WebElement e= driver.findElement(By.xpath("//a[contains(text(),'Interested to ')]"));
		actions.moveToElement(e).build().perform();
		
		
		
	}
	
	

}
