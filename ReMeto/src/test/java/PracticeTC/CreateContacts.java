package PracticeTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.metodisk.GenericUtils.ExcelUtility;
import com.crm.metodisk.GenericUtils.FileUtility;
import com.crm.metodisk.GenericUtils.JavaUtility;
import com.crm.metodisk.pomrepo.contacts.ContactInfo;
import com.crm.metodisk.pomrepo.contacts.ContactsHome;
import com.crm.metodisk.pomrepo.contacts.CreateNewContacts;
import com.crm.metodisk.pomrepo.organisation.OrganisationsHome;
import com.crm.metodisk.pomrepo.organisation.createNewOrg;
import com.crm.metodisk.pomrepository.homepage;
import com.crm.metodisk.pomrepository.login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContacts {
	@Test
	public void createContacts() throws Throwable {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\eclipse-workspace\\ReMeto\\software\\chromedriver1.exe");
		
		WebDriver driver=null;
		
		/*OBJECTS CREATION*/
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		
		/*READ COMMON DATA*/
		String USERNAME = fu.getPropertyKeyValue("username");
		String PASSWORD = fu.getPropertyKeyValue("password");
		String URL = fu.getPropertyKeyValue("url");
		String BROWSER = fu.getPropertyKeyValue("browser");
		
		/*READ TEST DATA*/
		String orgName = eu.getExelData("org", 4, 2)+"_"+JavaUtility.getRandomDate();
		String lastName = eu.getExelData("cont", 3, 1);
				
		/*LAUNCH BROWSER*/
			if(BROWSER.equals("chrome")) 
			{ driver=new ChromeDriver();}
			else if(BROWSER.equals("firefox"))	
			{ driver= new FirefoxDriver();}
			else {driver= new ChromeDriver();}
		
			
		/* OPEN THE APP AND LOGIN*/	
	    driver.get(URL);
	    login l=new login(driver);
	    l.loginToApp(USERNAME, PASSWORD);
	    
	    /*NAVIGATE TO ORGANISATION*/
	    homepage hp=new homepage(driver);
	    hp.getOrganisationButton().click();
	    
	    /*NAVIGATE TO CREATE ORGANISATION PAGE*/
	    OrganisationsHome oh=new OrganisationsHome(driver);
	    oh.getCreateOrg().click();
	    
	    /*CREATE ORGANISATION AND SAVE*/
	    createNewOrg cno=new createNewOrg(driver);
	    cno.createOrgName(orgName);
	    
	    Thread.sleep(3000);
	    	    
	    /*NAVIGATE TO CONTACTS PAGE*/
	    hp.getContactsButton().click();
	    
	    /*NAVIGATE TO CREATE CONTACTS*/
	    ContactsHome ch=new ContactsHome(driver);
	    ch.getCreateContactBtn().click();
	    
	    /*CREATE NEW CONTACT AND SAVE*/
	    CreateNewContacts cnc=new CreateNewContacts(driver);
	    cnc.createContactWithOrg(lastName, orgName);
	    
	    /*VERIFICATION*/
	    ContactInfo co=new ContactInfo(driver);
	    String ContactHeader = co.getContactHeader().getText();
	    if(ContactHeader.contains(lastName)) {
	    	System.out.println("Contact has been made succefully with organisation-"+orgName+"==>PASS");
	    }
	    else {System.out.println("contact has NOT been made.==>FAIL");
	    
	    /*LOGOUT AND CLOSE*/
	    hp.logout(driver);
	    driver.close();
	    
	}
	}
}

