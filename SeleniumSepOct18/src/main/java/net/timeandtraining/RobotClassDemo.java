package net.timeandtraining;



import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.automationpractice.framework.TestBase;

public class RobotClassDemo extends TestBase{

	
	
	@Test
	public void switchWindowDemoWithRobotClass() throws AWTException {
		
		ArrayList<String> windowHandles = new ArrayList<>();
		
		Actions actions = new Actions(driver);
		
		
		driver.get("http://automationpractice.com");
		
		actions.keyDown(Keys.CONTROL).build().perform();
		driver.findElement(By.xpath("//a[@title='Contact Us']")).click();
		actions.keyUp(Keys.CONTROL).build().perform();

		
		Set<String> wh=driver.getWindowHandles();
		wh.forEach((k)->{
			windowHandles.add(k);
			System.out.println(k);
		});
		
		//we are still in old tab
		
		driver.switchTo().window(windowHandles.get(1));
		
		WebElement orderRef=driver.findElement(By.id("id_order"));// from new tab
		orderRef.sendKeys("test");
		
		
		driver.switchTo().window(windowHandles.get(0));
		
		WebElement aptxt=driver.findElement(By.xpath("//h1[text()='Automation Practice Website']"));//from old tab
		System.out.println(aptxt.getText());
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
