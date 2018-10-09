package net.timeandtraining.testnggroupdemo;

import org.testng.annotations.Test;

public class MyAppTests {
	
	
	
	@Test(groups = {"functionalTest","smokeTest","integrationTest"})	
	public void testOne() {
		
	}
	
	@Test(groups = {"smokeTest"})
	public void testTwo() {
		
	}
	
	@Test(groups = {"integrationTest"})
	public void testThree() {
		
	}
	
	
	@Test(groups = {"smokeTest","integrationTest"})
	public void testFour() {
		
	}
	
	

}
