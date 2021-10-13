package PracticeTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.metodisk.GenericUtils.ExcelUtility;
import com.crm.metodisk.GenericUtils.FileUtility;
import com.crm.metodisk.GenericUtils.JavaUtility;
import com.crm.metodisk.GenericUtils.WebDriverUtility;
import com.crm.metodisk.pomrepo.organisation.OrganisationInfo;
import com.crm.metodisk.pomrepo.organisation.OrganisationsHome;
import com.crm.metodisk.pomrepo.organisation.createNewOrg;
import com.crm.metodisk.pomrepository.homepage;
import com.crm.metodisk.pomrepository.login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrg {
	/**
	 * @author -Kamaal
	 * @throws Throwable 
	 */
@Test
public void createOrg() throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=null;
	
	/* CREATING OBJECTS FOR UTILITIES */
	WebDriverUtility wdu=new WebDriverUtility();
	FileUtility fu=new FileUtility();
	ExcelUtility eu=new ExcelUtility();
	JavaUtility ju=new JavaUtility();
	
	/* READ COMMON DATA*/
	String URL = fu.getPropertyKeyValue("url");
	String USERNAME = fu.getPropertyKeyValue("username");
	String PASSWORD = fu.getPropertyKeyValue("password");
	String BROWSER = fu.getPropertyKeyValue("browser");
	
	/* READ TEST DATA*/
	String orgName = eu.getExelData("org", 2, 2)+"_"+JavaUtility.getRandomDate();
	System.out.println(orgName);
	
	/*LAUNCH BROWSER*/
	if(BROWSER.equals("firefox")) {
		driver=new FirefoxDriver();
	}else if(BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
	}else {driver=new ChromeDriver();}
	
	wdu.Maximise(driver);
	
	/*LAUNCH APP AND LOGIN*/
	driver.get(URL);
	login l =new login(driver);
	l.loginToApp(USERNAME, PASSWORD);
	
	/*NAVIGATE TO ORGANISATION*/
	homepage hp=new homepage(driver);
	hp.getOrganisationButton().click();
	
	/*NAVIGATE TO CREATE NEW ORG PAGE*/
	OrganisationsHome oh=new OrganisationsHome(driver);
	oh.getCreateOrg().click();
	
	/*FILL MANDATORY TEXT FIELD AND SAVE*/
	createNewOrg cno=new createNewOrg(driver);
	cno.createOrgName(orgName);
	cno.getSaveBtn().click();
	
	/*VERIFICATION*/
	OrganisationInfo oinfo= new OrganisationInfo(driver);
	wdu.waitForElementVisibility(driver, oinfo.getOrgHeader());
	String Header = oinfo.getOrgHeader().getText();
			if(Header.contains(orgName)) {
				System.out.println("Organisation is created succesfully==> PASSED");
			}else System.out.println("Organisation is NOT created succesfully==> FAILED");
    
	/*LOGOUT*/
	hp.logout(driver);
	
	/*CLOSE WINDOWS*/
	driver.close();
	
	 
}

}
