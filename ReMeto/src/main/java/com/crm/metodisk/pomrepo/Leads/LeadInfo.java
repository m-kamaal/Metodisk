package com.crm.metodisk.pomrepo.Leads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfo {
	WebDriver driver;
	public LeadInfo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//span[class='dvHeaderText']")
	private WebElement LeadHeader;
	public WebElement getLeadHeader() {
		return LeadHeader;
	}
	
	@FindBy(xpath="//a[text()='Convert Lead']")
	private WebElement convertLeadBtn;
	public WebElement getConvertLeadBtn() {
		return convertLeadBtn;
	}
	
	
	
	
	
}
