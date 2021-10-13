package LeadModuleWithBaseClass;
import org.testng.annotations.Test;

import com.crm.metodisk.GenericUtils.BaseClass;
import com.crm.metodisk.GenericUtils.JavaUtility;
import com.crm.metodisk.pomrepo.Leads.ConvertLead;
import com.crm.metodisk.pomrepo.Leads.CreateNewLead;
import com.crm.metodisk.pomrepo.Leads.LeadInfo;
import com.crm.metodisk.pomrepo.Leads.LeadsHome;
import com.crm.metodisk.pomrepository.homepage;

public class TC_27 extends BaseClass {
	@Test(groups= {"Smoke Test", "Regression Test"})
	public void tC_27() throws Throwable
	{
	
		/*READ TEST DATA*/
		String LN = elib.getExelData("lead", 3, 1)+"_"+JavaUtility.getRandomDate();
		String CN = elib.getExelData("lead", 3, 2);

		/*NAVIGATE TO LEAD PAGE*/
		homepage hp=new homepage(driver);
		hp.getLeadsButton().click();
		Thread.sleep(2000);
		
		/*NAVIGATE TO CREATE NEW LEAD PAGE*/
		LeadsHome lh=new LeadsHome(driver);
		lh.getCreateLeadBtn().click();
		
		/*CREATE LEAD AND SAVE IT*/
		CreateNewLead cnl=new CreateNewLead(driver);
		cnl.createLead(LN, CN);
		Thread.sleep(4000);
		
		/*NAVIGATE TO CONVERTLEAD*/
		LeadInfo li=new LeadInfo(driver);
		li.getConvertLeadBtn().click();
				
		/*NAVIGATE TO CHILD BROWSER ,PERFORM CHECK/UNCHECK ACTION AS PER TC AND SAVE*/
		ConvertLead cl=new ConvertLead(driver);
		wlib.waitForElementVisibility(driver, cl.getOpportunityCheckboxBtn());
		wlib.switchToWindow(driver, "Convert Lead :");
	    cl.getOrgCheckboxBtn().click();
	    cl.getOpportunityCheckboxBtn().click();
	    cl.EnterDate();	    
	    cl.getSaveBtn().click();
	    
				
	}

}
