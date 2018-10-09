package net.timeandtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.automationpractice.framework.TestBase;

public class DriverSwitchDemo extends TestBase{
	
	
	@Test
	public void windowSwitchDemo() {
		
		String browser1=driver.getWindowHandle();
		driver.get("http://www.google.com");
		
//		driver = new ChromeDriver();
		
		String browser2=driver.getWindowHandle();
		driver.get("https://www.cnn.com/");
		
		
		driver.switchTo().window(browser1);
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		driver.switchTo().window(browser2);
		driver.findElement(By.id("nav-mobileTV")).click();
		
	}
	
	@Test
	public void frameDemo() {
		driver.get("https://www.tutorialspoint.com/online_html_editor.php");
		driver.switchTo().frame(1);
		String s=driver.findElement(By.xpath("//a[@class='title-link']")).getText();
		driver.switchTo().defaultContent();		
		System.out.println(s);
		
		
	}
	
	
	@Test
	public void alertDemo() {
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		
		driver.findElement(By.xpath("//button[text()='click to see the date and time']")).click();
		
		driver.switchTo().alert().accept();
		
		
		
		
	}

}
