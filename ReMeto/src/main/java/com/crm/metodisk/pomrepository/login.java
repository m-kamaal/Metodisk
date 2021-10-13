package com.crm.metodisk.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class login {
	
	public login (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPassEdt;
	
	@FindAll({@FindBy(id="submitButton") , @FindBy(xpath="//input[@id='submitButton']")}) //Autohealing
	private WebElement loginButton;


	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getUserPassEdt() {
		return userPassEdt;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp(String username , String password) {
		userNameEdt.sendKeys(username);
		userPassEdt.sendKeys(password);
		loginButton.click();
	}


}
