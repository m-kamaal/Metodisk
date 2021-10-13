package PracticeTC;

import org.testng.annotations.Test;

import com.crm.metodisk.GenericUtils.ExcelUtility;

public class ExcelSheetIssue {
	@Test
	public void ExcelSheetIssue() throws Throwable {
		
		//TEMPORARY
				ExcelUtility ex=new ExcelUtility();
				String edata1 = ex.getExelData("Sheet1",1,1);
				String edata2 = ex.getExelData("Sheet1",1,2);
				System.out.println(edata1);
				System.out.println(edata2);
		
	}

}
