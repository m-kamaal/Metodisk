package com.crm.metodisk.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * This method is to generate random number to avoid duplicates
	 * @return
	 */
	public static String getRandomDate()
	   {
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;	
		}
	
	/**
	 * This method is used to generate current date
	 * @return current date
	 */
	public static String getCurrentDate()
	{
		Date date=new Date();
		String currentdate=date.toString();
		return currentdate;			
	}
	
	public static String getCurrentDate2() {
		Date dateobj=new Date();
		String CurrentTimeAndDate= dateobj.toString();		
		int month=dateobj.getMonth()+1;		
		int date=dateobj.getDate();		
		String year=CurrentTimeAndDate.split(" ")[5];		
		String actdate= year+"-"+month+"-"+date;
		return actdate;
	}
	
	
	
	
	
	
}
