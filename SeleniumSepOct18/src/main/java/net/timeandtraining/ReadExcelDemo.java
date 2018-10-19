package net.timeandtraining;

import java.util.List;

import com.rkreja.Excel;

public class ReadExcelDemo {

	public static void main(String[] args) {
		
		
		Excel excel = new Excel("C:\\Users\\rkreja\\Desktop\\SeleniumSepOct18Batch\\testdata.xlsx", "Sheet1");
		
//		for(int i=1;i<=excel.rowCount();i++) {
//		System.out.println(excel.getCellValueAsString(i, 2));	
//		}
//		
		List<String> headers=excel.getColHeaders();
		
		for(String s:headers) {
			System.out.println(s);
		}
		
		
		System.out.println(excel.getRowByData("Zipcode", "10985"));
		
		
		
		
		
		
		

	}

}
