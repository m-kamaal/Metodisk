package com.crm.metodisk.pomrepo.Leads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsHome {
     
	WebDriver driver;
	public LeadsHome(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	/*CREATE LEAD BUTTON*/
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createLeadBtn;
	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}
}
