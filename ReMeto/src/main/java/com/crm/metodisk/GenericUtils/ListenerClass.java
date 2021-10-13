package com.crm.metodisk.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		System.out.println(testName+"==============Execute & I am Listening===============");
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("./Screenshot/"+testName+".png") );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
