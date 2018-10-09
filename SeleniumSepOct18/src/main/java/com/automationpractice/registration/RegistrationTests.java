package com.automationpractice.registration;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests {
    @Test
	public void Register_a_new_account_in_automationpractice_com() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Orthi\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES );
		//Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		//Click Sign in button from top right corner of the page
		driver.findElement(By.className("login")).click();
		//Enter email address 'abc@mailinator.com' in email address text field of left side
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("abc@mailinator.com");
		//Click create an account button
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
//		Verify error message displayed 'An account using this email address has already been registered. Please enter a valid password or request a new one.'
		String text= driver.findElement(By.xpath("//li[parent::ol]")).getText(); 
		Assert.assertEquals(text, "An account using this email address has already been registered. Please enter a valid password or request a new one.");
		//Enter a valid email address in email address text field. (You can use ritabv06@mailinator.com)
		driver.findElement(By.xpath("//input[@name='email_create']")).clear();
		driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys("ritabv"+ThreadLocalRandom.current().nextInt(1000, 9999)+"@mailinator.com");
		//Click create an account button
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		//Click 'Register' button
    	driver.findElement(By.xpath("//button[@name='submitAccount']")).click();
//    	Verify error message displayed 'You must register at least one phone number.
    	String text1= driver.findElement(By.xpath("//li[contains(text(),'register')]")).getText(); 
		Assert.assertEquals(text1, "You must register at least one phone number.");
//		Verify error message displayed 'lastname is required.'
		String text2= driver.findElement(By.xpath("(//li[parent::ol])[2]")).getText(); 
		Assert.assertEquals(text2, "lastname is required.");
//		Verify error message displayed 'firstname is required.'
		String text3= driver.findElement(By.xpath("(//li[parent::ol])[3]")).getText(); 
		Assert.assertEquals(text3, "firstname is required.");
//		Verify error message displayed 'passwd is required.'
		String text4= driver.findElement(By.xpath("(//li[parent::ol])[4]")).getText(); 
		Assert.assertEquals(text4, "passwd is required.");
//		Verify error message displayed 'address1 is required.'
		String text5= driver.findElement(By.xpath("(//li[parent::ol])[5]")).getText(); 
		Assert.assertEquals(text5, "address1 is required.");
//		Verify error message displayed 'city is required.'
		String text6= driver.findElement(By.xpath("(//li[parent::ol])[6]")).getText(); 
		Assert.assertEquals(text6, "city is required.");
//		Verify error message displayed 'The Zip/Postal code you've entered is invalid. It must follow this format: 00000'
		String text7= driver.findElement(By.xpath("(//li[parent::ol])[7]")).getText(); 
		Assert.assertEquals(text7, "The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
//		Verify error message displayed 'This country requires you to choose a State.'
		String text8= driver.findElement(By.xpath("(//li[parent::ol])[8]")).getText(); 
		Assert.assertEquals(text8, "This country requires you to choose a State.");
//		Select 'Mr' radio button
		driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
//		Enter First name as 'John'
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("John");
//		Enter Last name as 'Smith'
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Smith");
//		Verify Email text box has email address defined as used in step 6
		String text9=driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
       Assert.assertEquals(text9, "ritabv06@mailinator.com");
//		Enter password as 'MyStrong_Password'
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("MyStrong_Password");
//		Select day 15 from day dropdown
    	Select Day_drop_down=new Select(driver.findElement(By.xpath("//select[@id='days']")));
		Day_drop_down.selectByIndex(15);
//		Select year 1984 from year dropdown
		Select Year_drop_down=new Select(driver.findElement(By.xpath("//select[@id='years']")));
		Year_drop_down.selectByValue("1984");
//		Select month September from month dropdown
		Select Month_drop_down=new Select(driver.findElement(By.xpath("//select[@id='months']")));
		Month_drop_down.selectByValue("9");
//		Verify First name text field below has first name defined as used in step 18
		String text10=driver.findElement(By.xpath("//input[@id='customer_firstname']")).getAttribute("value");
		Assert.assertEquals(text10, "John");
//		Verify First name text field below has last name defined as used in step 19
		String text11=driver.findElement(By.xpath("//input[@id='customer_lastname']")).getAttribute("value");
		Assert.assertEquals(text11, "Smith");

//		Enter Company as 'Time and Training' in Company text field
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Time and Training");
//		Enter address as '123 abc street' in address text field
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("123 abc street");
//		Enter city New York in city text field
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York");
//		Select state New York from state drop down
		Select State_drop_down=new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		State_drop_down.selectByValue("32");;
//		Enter '10001' in Zip/Postal Code text field	
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("10001");
//		Select country United States from country dropdown
		Select Country_drop_down=new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		Country_drop_down.selectByValue("21");
//		Enter text 'Registering ac account with all fields' in Additional information text area
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Registering ac account with all fields");
//		Enter '7031234567' in Home Phone text field
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("7031234567");
//		Enter Enter '7039876543214' in Mobile phone text field
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("7039876543214");
//		Replace text 'My Address' to 'Home' in Assign an address alias for future reference text field
    	driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("My Address' to 'Home");
//		Click 'Register' button
//		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

		

		
    }
}
