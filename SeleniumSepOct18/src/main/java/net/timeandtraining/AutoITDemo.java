package net.timeandtraining;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationpractice.framework.TestBase;

public class AutoITDemo extends TestBase{
	
	
	
	@Test
	@Parameters("os")
	public void fileupload(String os) {
		driver.get("https://timeandtraining.net/seleniumdemo/selenium.html");
		driver.findElement(By.id("demoFileUpload")).click();
		
		
		if(os.equals("windows")) {
			try {
				Runtime.getRuntime().exec("autoitscripts\\fileuploadDemo.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}else if(os.equals("mac")) {
			//
			//
			//
			
		}
		
		
		
		
	}
}
