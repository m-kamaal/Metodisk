package PracticeTC;

import org.apache.xmlbeans.impl.common.XPath;
import java.util.Date;

import com.crm.metodisk.GenericUtils.JavaUtility;



public class Calendar {

	
	public static void main(String[] args) {
		
		
	   Date dateobj=new Date();
		String CurrentTimeAndDate= dateobj.toString();
		
		int month=dateobj.getMonth()+1;
		
		int date=dateobj.getDate();
		
		String year=CurrentTimeAndDate.split(" ")[5];
		
		String actdate= year+"-"+month+"-"+date;
		
		System.out.println(actdate);
		
		
		
		System.out.println();
		
	}

	
	
}
