package net.timeandtraining.testnggroupdemo;

import org.testng.annotations.Test;

public class MyAppTests {
	

	@Test
	public void createTestData() {
		System.out.println("test data created");
	}
	
	@Test
	public void testReg() {
		System.out.println("user created : mark");
	}
	
	@Test(dependsOnMethods= {"testReg","createTestData"})
	public void testLogin() {
		System.out.println("user 'mark' logged in");
	}
	
	
	
	
	
	
	
	
/*	
	
	
	
	
	
	
	
	
	
	
	
	@Test(groups = {"functionalTest","smokeTest","integrationTest"})	
	public void testOne() {
		//register
		//userid created 'mark'
	}
	
	@Test(groups = {"smokeTest"})
	public void testTwo() {
		//login using user id 'mark'
	}
	
	@Test(groups = {"integrationTest"})
	public void testThree() {
		
	}
	
	
	@Test(groups = {"smokeTest","integrationTest"})
	public void testFour() {
		
	}*/
	
	

}
