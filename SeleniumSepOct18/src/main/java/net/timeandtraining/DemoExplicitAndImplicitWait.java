package net.timeandtraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DemoExplicitAndImplicitWait {
	@Test
	public static void explicitWait() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-warning")));
		driver.findElement(By.className("btn-warning")).click();

	}
	@Test
	public static void implicitWait() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		String s=driver.findElement(By.xpath("//p[contains(text(),'Dream is not the thing ')]")).getText();
		System.out.println(s);

	}
	@Test
	public static void implicitWait2() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		
		WebDriverWait wait  = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Dream is not the thing')]")));
		
		driver.findElement(By.xpath("//button[text()='click to see the date and time']")).click();
		

	}
	
}
