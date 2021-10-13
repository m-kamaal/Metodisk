package com.crm.metodisk.pomrepo.contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfo {
	
	public ContactInfo(WebDriver driver){
		
		PageFactory.initElements(driver,this);
		}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeader;

	public WebElement getContactHeader() {
		return contactHeader;
	}
}
