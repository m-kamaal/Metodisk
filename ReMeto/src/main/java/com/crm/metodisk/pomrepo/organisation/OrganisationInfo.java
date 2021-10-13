package com.crm.metodisk.pomrepo.organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfo {
	WebDriver driver;
	public OrganisationInfo(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeader;
	public WebElement getOrgHeader() {
		return orgHeader;
	}
}
