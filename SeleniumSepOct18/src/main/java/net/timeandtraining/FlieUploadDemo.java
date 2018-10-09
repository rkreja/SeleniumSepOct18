package net.timeandtraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlieUploadDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		
		driver.findElement(By.id("demoFileUpload")).sendKeys("C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\DemoFileUpload.txt");
		
	}

}
