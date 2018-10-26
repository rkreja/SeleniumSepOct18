package net.timeandtraining;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rkreja.Excel;

public class DataDrivenTestWithDataProvider{

	@DataProvider(name="testDataAll")
	public Object[][] getDataAll(){
		
		
		Excel excel = new Excel("C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\testdata.xlsx", "Sheet1",false);
		return excel.getRowValuesForDataProvider();
		
		
	
		
	}
	
	@DataProvider(name="testData")
	public Object[][] getData(){
		
		/*
		Excel excel = new Excel("C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\testdata.xlsx", "Sheet1",false);
		return excel.getRowValuesForDataProvider();
		*/
		
		
		Excel excel = new Excel("C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\testdata.xlsx", "Sheet1");
		
		Object[][] data = new Object[excel.rowCount()][1];
		
		List<String> records=excel.getAllRowValuesByColumn(1);
		
		for(int i=0; i<records.size();i++) {
			
			data[i][0]=records.get(1);
		}
		
		
		return data;		
		
	}
	
	
	@DataProvider(name="testDataCity")
	public Object[][] getDataForCity(){
		
		/*
		Excel excel = new Excel("C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\testdata.xlsx", "Sheet1",false);
		return excel.getRowValuesForDataProvider();
		*/
		
		
		Excel excel = new Excel("C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\testdata.xlsx", "Sheet1");
		
		
		Object[][] data = new Object[excel.rowCount()][1];
		
		List<String> records=excel.getAllRowValuesByColumn(2);
		
		for(int i=0; i<records.size();i++) {
			
			data[i][0]=records.get(1);
		}
		
		
		return data;		
		
	}
	
	@Test(dataProvider="testData")
	public void testZipCode(String zip) {
		
		System.out.println(zip);
		
	}
	

	@Test(dataProvider="testDataCity")
	public void testZipCode2(String city) {
		
		System.out.println(city);
		
	}
	

	
	
	
	@Test(dataProvider="testDataAll")
	public void testZipCode(String zip, String city, String stateName, String stateCode, String country, String lat, String lon) {
		
		System.out.println(zip);
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		
		
		String[][] myArr = new String[3][3];
		
		myArr[0][0]="name";
		myArr[0][1]="age";
		myArr[0][2]="dob";
		
		myArr[1][0]="mike";
		myArr[1][1]="28";
		myArr[1][2]="07011992";
		
		myArr[2][0]="mary";
		myArr[2][1]="26";
		myArr[2][2]="07011996";
		
		System.out.println(myArr[2][2]);
		
		
		myArr[2][2]="52";
		
		
		System.out.println(myArr[2][2]);
		
		
		
		
	}

}


