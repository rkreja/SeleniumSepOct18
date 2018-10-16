package net.timeandtraining.testnggroupdemo;

import org.testng.annotations.Test;

public class TestNGMiscDemo {

	@Test(groups = {"functionalTest","smokeTest","integrationTest"})	
	public void testOne() {
		
	}
	@Test(testName="")
	public void a() {
		
	}
	@Test(priority=2)
	public void b() {
		
	}
	@Test(priority=3)
	public void c() {
		
	}
	@Test(priority=4)
	public void testFour() {
		
	}
	@Test
	public void testFive() {
		
	}
	@Test
	public void testSix() {
		
	}
	
	
}

