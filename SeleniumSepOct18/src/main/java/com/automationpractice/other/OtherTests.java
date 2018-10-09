package com.automationpractice.other;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.framework.TestBase;


public class OtherTests extends TestBase{
    @Test
	public void Send_message_using_contact_us_form() {
//		Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
//		Click Sign in button from top right corner of the page
		driver.findElement(By.xpath("//a[@class='login']")).click();
//		Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc213@mailinator.com");
//		Enter valid password 'abc1234' in password text field
		driver.findElement(By.xpath("//input[@id='passwd'] ")).sendKeys("abc1234");
//		Click 'Sign in' button
		driver.findElement(By.xpath("//button[@id='SubmitLogin'] ")).click();
//		Click Contact us button from top right menu
		driver.findElement(By.xpath("//a[@title='Contact Us']")).click();
//		Select 'Webmaster' from Subject Heading drop down
		Select Subject_Heading_dropdown=new Select(driver.findElement(By.xpath("//select[@id='id_contact']")));
		Subject_Heading_dropdown.selectByVisibleText("Webmaster");
//	    Type message 'I have not received my order yet' in Message text area
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("I have not received my order yet");
//		Upload a text file in Attach file option
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\Users\\Orthi\\Desktop\\selenium\\order.txt");
//		Click Send button
		driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
//		Verify 'Your message has been successfully sent to our team.' message displayed
		String text=driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
		Assert.assertEquals(text, "Your message has been successfully sent to our team."); 
		
				
		
		

	}
    @Test
	public void Send_message_with_order_reference_using_contact_us_form () {
//	Go to http://www.automationpractice.com
	driver.get(" http://www.automationpractice.com");
//	Click Sign in button from top right corner of the page
	driver.findElement(By.xpath("//a[@class='login']")).click();
//	Enter valid email address 'abc213@mailinator.com' in email address text field of right side
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc213@mailinator.com");
//	Enter valid password 'abc1234' in password text field	Enter valid password 'abc1234' in password text field
	driver.findElement(By.xpath("//input[@id='passwd'] ")).sendKeys("abc1234");
//	Click 'Sign in' button
	driver.findElement(By.xpath("//button[@id='SubmitLogin'] ")).click();
//	Click Contact us button from top right menu
	driver.findElement(By.xpath("//a[parent::div[@id='contact-link']]")).click();
//	Select 'Customer 'Service' from Subject Heading drop down
	Select Subject_heading_dropdown=new Select(driver.findElement(By.xpath("//select[@id='id_contact']")));
	Subject_heading_dropdown.selectByIndex(1);
//	Select 'UOYFIFFGJ - 04/08/2018' from Order reference drop down
	Select Order_reference_drop_down=new Select( driver.findElement(By.xpath("//select[@name='id_order']")));
	Order_reference_drop_down.selectByVisibleText("UOYFIFFGJ - 04/08/2018");
//	Select 'Printed Dress - Color : Orange, Size : S' from Product drop down
	Select Product_drop_down=new Select(driver.findElement(By.xpath("//select[@id='39750_order_products']")));
	Product_drop_down.selectByVisibleText("Printed Dress - Color : Orange, Size : S");
//	Type message 'I have not received my order yet' in Message text area
	driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("I have not received my order yet");
//	Click Send button
	driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
//	Verify 'Your message has been successfully sent to our team.' message displayed
	String text=driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
	Assert.assertEquals(text, "Your message has been successfully sent to our team.");
	

	}
    @Test
	public void Newsletter_subscription() {
		
   	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		
//		Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
//		Enter an email address to Newsletter textfield at the bottom
		driver.findElement(By.xpath("//input[@id='newsletter-input']")).sendKeys("orthibv@icloud.com");
//		Press Enter by keyboard
		driver.findElement(By.xpath("//button[@name='submitNewsletter']")).click();
//	problem***	Verify message 'Newsletter : You have successfully subscribed to this newsletter.' displayed
		String text=driver.findElement(By.xpath("//p[contains(@class,'alert')]")).getText();
	    Assert.assertEquals(text, "Newsletter : You have successfully subscribed to this newsletter.");
    }

}
