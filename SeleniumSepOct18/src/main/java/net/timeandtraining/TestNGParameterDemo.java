package net.timeandtraining;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationpractice.framework.TestBase;

public class TestNGParameterDemo extends TestBase{
	
	
	
	
	@Test
	@Parameters({"url"})
	public void nav(String url) {
		
		driver.get(url);
	}
	
	

}
