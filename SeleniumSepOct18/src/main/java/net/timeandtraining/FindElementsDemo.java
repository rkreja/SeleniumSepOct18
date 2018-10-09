package net.timeandtraining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElementsDemo {

	
	@Test
	public void getMultipleValuesFromElements() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		
		ArrayList<WebElement> elements=(ArrayList<WebElement>) driver.findElements(By.xpath("//input[contains(@id,'exampleRadios')]"));
		
		
		HashMap<String,String> map = new HashMap<>();
		for(int i=0;i<elements.size();i++) {
			
			String value=elements.get(i).getAttribute("value");
			String id=elements.get(i).getAttribute("id");
			map.put(id, value);
		
		}
		
		
		map.forEach((k,v)->{
			System.out.println(k);
			System.out.println(v);
		});
		
		
		
		
		
	}
	
	

}
