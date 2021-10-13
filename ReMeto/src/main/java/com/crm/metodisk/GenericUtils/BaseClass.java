package com.crm.metodisk.GenericUtils;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.metodisk.pomrepository.homepage;
import com.crm.metodisk.pomrepository.login;

/**
 * This Class contains basic configuration annotations of testng
 * @author Kamaal
 */
public class BaseClass {
	
  /*PUBLIC OBJECT CREATION*/
  
	public ExcelUtility elib= new ExcelUtility();
	public FileUtility flib= new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite(groups= {"Smoke Test","Regression Test"})
	public void connectDB() throws SQLException {
		//dlib.connectToDB();
		System.out.println("=============DB Connection Succesful============");
	}
	
	@BeforeClass(groups= {"Smoke Test"})
	public void launchBrowser() throws Throwable {
		/*READ DATA FROM PROPERTY FILE*/
		String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else driver=new ChromeDriver();
		
		System.out.println("=============browser launched succefully===========");
		
		sDriver=driver;
		wlib.Maximise(driver);
		wlib.WaitUntilPageLoad(driver);
		driver.get(URL);		
	}
	
	@BeforeMethod(groups= {"Smoke Test"})
	   public void loginToApp() throws Throwable
	   {
		   //read data from property file
		  String USERNAME = flib.getPropertyKeyValue("username");
		  String PASSWORD = flib.getPropertyKeyValue("password");
	      
		  //login to App
		  login lp= new login(driver);
		  lp.loginToApp(USERNAME, PASSWORD);
		  System.out.println("login successful");
	    }
	   @AfterMethod(groups= {"Smoke Test"})
	   public void logoutofApp()
	   {
		  homepage hp=new homepage(driver);
		  hp.logout(driver);
		  System.out.println("signout successfull");
	   }
	   @AfterClass(groups= {"Smoke Test"})
	   public void CloseBrowser() {
		   driver.close();
		   System.out.println("browser close successfully");
	   }
	   @AfterSuite(groups= {"Smoke Test"})
	   public void closeDB() throws SQLException
	   {
		   //dlib.closeDB();
		   System.out.println("dm connection close suceessfully ");
	   }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

