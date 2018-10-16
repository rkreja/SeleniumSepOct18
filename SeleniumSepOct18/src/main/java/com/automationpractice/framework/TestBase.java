package com.automationpractice.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	
	protected WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void init(@Optional("chrome") String browser) {
		
		
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver-windows-32bit.exe");
			driver = new ChromeDriver();
			break;
			
		case "internetexplorer":
			System.setProperty("webdriver.ie.driver", "lib\\internetexplorerdriver-windows-32bit.exe");
			driver = new InternetExplorerDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver-windows-32bit.exe");
			driver = new ChromeDriver();
			break;
		}
		
	
		/*if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver-windows-32bit.exe");
			driver = new ChromeDriver();	
		}else if(browser.equalsIgnoreCase("internetexplorer")) {
			System.setProperty("webdriver.ie.driver", "lib\\internetexplorerdriver-windows-32bit.exe");
			driver = new InternetExplorerDriver();
		}*/
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
