package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	private WebDriver driver;
	
	@FindBy(id="email")
	public WebElement textfield_email_signin;
	
	@FindBy(id="passwd")
	public WebElement textfield_pwd_signin;
	
	
	@FindBy(id="SubmitLogin")
	public WebElement button_signin;
	
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getErrorMsg() {
		return this.driver.findElement(By.xpath("(//div[contains(@class,'alert')])[1]")).getText();
	}
	
	
}
