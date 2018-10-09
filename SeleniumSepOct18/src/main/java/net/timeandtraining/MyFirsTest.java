package net.timeandtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirsTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//navigating to a web site
		driver.get("http://automationpractice.com/index.php");
		
			
		//find first then..
		
				
		//click
		
	
		//type
		driver.findElement(By.id("search_query_top")).sendKeys("summer");
		
		//click search button
		driver.findElement(By.name("submit_search")).click();
	
		
		
		
		//read
		
		
		

	}

}
