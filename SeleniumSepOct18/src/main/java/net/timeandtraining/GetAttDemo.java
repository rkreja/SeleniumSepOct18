package net.timeandtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAttDemo {
	
	@Test
	public void testOne() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//go to this site: https://timeandtraining.net/seleniumdemo/selenium.html
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		
		//verify the button at the bottom has link to: https://www.timeandtraining.net/
		String txt=driver.findElement(By.className("btn-lg")).getAttribute("href");
		Assert.assertEquals(txt, "https://www.timeandtraining.net/");

	}
}
