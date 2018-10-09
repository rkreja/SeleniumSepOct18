package net.timeandtraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		Select language_dropdown = new Select(driver.findElement(By.xpath("(//select[@name='DemoDropDown'])[2]")));
		language_dropdown.selectByVisibleText("Class");
		
	}

}
