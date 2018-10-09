package net.timeandtraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	protected WebDriver driver=null;
	
	public Base() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	
}
