package com.automationpractice.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationpractice.framework.TestBase;
import com.automationpractice.framework.UI;
public class LoginTests extends TestBase{
	
	
   @Test(testName="Login with invalid userid and password",description="detail description")
 	public void Login_with_invalid_userid_with_ui() {
    	
    	UI ui = new UI(driver);
    	
    	
//		Go to http://www.automationpractice.com
//		driver.get("http://www.automationpractice.com");
		ui.openUrl("http://www.automationpractice.com");
//		Click Sign in button from top right corner of the page
		
		ui.clickByClassName("login");
		
		
//		Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
		ui.enterTextById("email", "myunknowxaad@mailinator.com");
//		Click Sign in button
		ui.clickById("SubmitLogin");
		
		
		
//		Verify error message displayed 'There is 1 error'
		String text1=driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
		Assert.assertEquals(text1, "There is 1 error");
//		Verify error message displayed 'Password is required.'
		String text2=driver.findElement(By.xpath("//li[parent::ol]")).getText();
		Assert.assertEquals(text2, "Password is required.");

	}
    
    
    @Test
 	public void Login_with_invalid_userid() {
//		Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
//		Click Sign in button from top right corner of the page
		driver.findElement(By.className("login")).click();
//		Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
		driver.findElement(By.id("email")).sendKeys("myunknowxaad@mailinator.com");
//		Click Sign in button
		driver.findElement(By.id("SubmitLogin")).click();
//		Verify error message displayed 'There is 1 error'
		String text1=driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
		Assert.assertEquals(text1, "There is 1 error");
//		Verify error message displayed 'Password is required.'
		String text2=driver.findElement(By.xpath("//li[parent::ol]")).getText();
		Assert.assertEquals(text2, "Password is required.");

	}
    @Test
	public void Login_with_valid_userid_but_invalid_password() {
		
		//Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		//Click Sign in button from top right corner of the page
		driver.findElement(By.className("login")).click();
		//Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		driver.findElement(By.id("email")).sendKeys("abc213@mailinator.com");
//		Enter invalid password 'myinvalidpwd' in password text field
		driver.findElement(By.id("passwd")).sendKeys("myinvalidpwd");
		//Click 'Sign in' button
		driver.findElement(By.id("SubmitLogin")).click();
		//Verify error message displayed 'There is 1 error'
		String text3=driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
		Assert.assertEquals(text3, "There is 1 error");
		//Verify error message displayed 'Authentication failed.'
		String text4=driver.findElement(By.xpath("//li[parent::ol]")).getText();
		Assert.assertEquals(text4, "Authentication failed.");
     
    	
    }
    @Test
    @Parameters({"validuserid","validpassword"})
    public void Login_with_valid_userid_and_password(String validUserId, String validPassword) {
		  //Go to http://www.automationpractice.com
    	     driver.get("http://www.automationpractice.com");
    		//Click Sign in button from top right corner of the page
    	     driver.findElement(By.xpath("//a[@class='login']")).click();
    		//Enter valid email address 'abc213@mailinator.com' in email address text field of right side
    	     driver.findElement(By.xpath("//input[@id='email']")).sendKeys(validUserId);
    		//Enter valid password 'abc1234' in password text field
    	     driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(validPassword);
    		//Click 'Sign in' button
    	     driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
    		//Verify 'MY ACCOUNT  ' text displayed
    	    String text5= driver.findElement(By.xpath("//h1[text()='My account']")).getText();
    	     Assert.assertEquals(text5, "MY ACCOUNT");
    		//Verify 'Welcome to your account. Here you can manage all of your personal information and orders.' text displayed
    	     text5= driver.findElement(By.className("info-account")).getText();
//    	     
//    	     System.out.println(text5);
//    	     System.out.println("Welcome to your account.Here you can manage all of your personal information and order");
//    	     
    	     Assert.assertEquals(text5, "Welcome to your account. Here you can manage all of your personal information and orders.");
    		//Verify 'My personal information' text displayed
    	    text5= driver.findElement(By.xpath("//span[text()='My personal information']")).getText();
    	    Assert.assertEquals(text5, "MY PERSONAL INFORMATION");
    		//Click 'Sign out' button from top right corner
    	    driver.findElement(By.xpath("//a[@class='logout']")).click();
    }
	

}
