package com.automationpractice.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UI{
	
	WebDriver driver=null;
	
	public UI(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void openUrl(String url) {
		driver.get(url);
	}
	
	public void clickByClassName(String className) {
		driver.findElement(By.className(className)).click();
	}
	public void clickById(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	
	public void enterTextById(String id, String txt) {
		driver.findElement(By.id(id)).sendKeys(txt);
	}
	
	
	

}
