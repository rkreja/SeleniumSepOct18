package net.timeandtraining;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGAnnocationDemo {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Broswer opened");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("Broswer closed");
	}
	
	@BeforeMethod
	public void getTestData(){
		System.out.println("Test data supplied");
	}
	
	@Test
	public void testOne(){
		System.out.println("this is test one");
	}
	@Test
	public void testTwo(){
		System.out.println("this is test two");
	}
	@Test
	public void testThree(){
		System.out.println("this is test three");
	}
	@Test
	public void testFour(){
		System.out.println("this is test four");
	}
	@Test
	public void testFive(){
		System.out.println("this is test five");
	}
	
	

}
