package com.crm.metodisk.GenericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{	
	
	int count;
    int retryCount;
	
	public boolean retry(ITestResult result) {
		
		if(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}
}	


