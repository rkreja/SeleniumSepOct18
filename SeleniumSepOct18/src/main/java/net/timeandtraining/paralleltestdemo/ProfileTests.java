package net.timeandtraining.paralleltestdemo;

import org.testng.annotations.Test;

import com.automationpractice.framework.TestBase;

public class ProfileTests extends TestBase{
	
	
	@Test
	public void testOne() {
		driver.get("http://www.google.com");
	}
	@Test
	public void testTwo() {
		driver.get("http://www.google.com");
	}
	@Test
	public void testThree() {
		driver.get("http://www.google.com");
	}
	@Test
	public void testFour() {
		driver.get("http://www.google.com");
	}
	
	

}
