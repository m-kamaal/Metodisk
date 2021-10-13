package com.crm.metodisk.pomrepo.contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsHome {
	
	WebDriver driver;
	
	public ContactsHome(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactBtn;

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
	
}
