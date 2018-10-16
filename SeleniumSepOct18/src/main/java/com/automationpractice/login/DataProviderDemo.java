package com.automationpractice.login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.framework.TestBase;

public class DataProviderDemo extends TestBase{
	
	
//	@Test
//	@Parameters({"urlForTest2"})
//	public void navbigatesRandomWebsites(String url) {
//		driver.get(url);
//	}
	

	@DataProvider(name="dtp")
	public Object[][] prepareData(){
		return new Object[][] {
			{"http://www.cnn.com"},
			{"http://www.facebook.com"},
			{"http://www.bbc.com"}
		};
	}
	
	@Test(dataProvider="dtp")
	public void navbigatesRandomWebsites(String url) {
		driver.get(url);
	}


	

}
