package com.automationpractice.purchase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PurchaseTests {
	@Test

	public void Purchase_a_T_Shirt()  {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
//	Go to http://www.automationpractice.com
	driver.get("http://www.automationpractice.com");
//	Click 'DRESSES' button
	driver.findElement(By.xpath("(//a[@title='Dresses'])[2]")).click();
//	Click 'CASUAL DRESSES' thumnail under Subcategories
	driver.findElement(By.xpath("(//a[@class='subcategory-name'])[1]")).click();
//	problem***Mouse hover to the thumbnail of 'Printed Dress' image
//	Click 'Add to Cart' button
	driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
//problem	Verify message displayed 'Product successfully added to your shopping cart'
	String myxapth="//h2[preceding-sibling::span[@class='cross']]";
	
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.textToBe(By.xpath(myxapth), "Product successfully added to your shopping cart"));

//	try {
//		Thread.sleep(10000);
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	}
	//ata dia amra by force wait korasi .akane elementt pak ba na pac 10 sc wait korbe.ar explicit wait a pele ar wait korbe na
	
	String text1=driver.findElement(By.xpath(myxapth)).getText();
	Assert.assertEquals(text1, "Product successfully added to your shopping cart");
//	Verify message displayed 'There are 1 items in your cart.'
	String myxapth1=("(//span[contains(@class,'ajax')])[10]");
//	WebDriverWait wait1 = new WebDriverWait(driver, 60);
//	wait1.until(ExpectedConditions.textToBe(By.xpath(myxapth1), "There are 1 items in your cart."));
//	try {
//	Thread.sleep(10000);
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//		}

	
    String text2=driver.findElement(By.xpath(myxapth1)).getText();
	Assert.assertEquals(text2, "There is 1 item in your cart.");
//	Verify message displayed 'Total products $26.00'
	String text3=driver.findElement(By.xpath("(//div[contains(@class,'layer_cart_row')])[1]")).getText();
    Assert.assertEquals(text3,"Total products $26.00" );
//    Verify message displayed 'Total shipping $2.00'
    String text4=driver.findElement(By.xpath("(//div[contains(@class,'layer_cart_row')])[2]")).getText();
    Assert.assertEquals(text4,"Total shipping  $2.00" );
//    Verify message displayed 'Total $28.00'
    String text5=driver.findElement(By.xpath("(//div[contains(@class,'layer_cart_row')])[3]")).getText();
    Assert.assertEquals(text5,"Total $28.00" );
//    Verify message displayed 'Customers who bought this product also bought:'
    String text6=driver.findElement(By.xpath("//h2[parent::div[@class='crossseling-content']]")).getText();
    Assert.assertEquals(text6,"Customers who bought this product also bought:" );


	//	Click 'Proceed to checkout' button
//	try {
//		Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			}

	driver.findElement(By.xpath("(//a[contains(@class,'btn btn-default')])[2]")).click();
	
//	Verify url has 'controller=order'
//	Verify page title is: 'Order - My Store'
//		Click 'Proceed to checkout' button
//
	
	
	driver.findElement(By.xpath("(//span[contains(text(),'Proceed')])[1]")).click();
//		Verify page title is: 'Login - My Store'
//		Enter valid email address 'abc213@mailinator.com' in email address text field of right side
	

	}

}
