package com.crm.comcast.organizationtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.pomrepositylib.CreateOrganizations;
import com.crm.comcast.pomrepositylib.Home;
import com.crm.comcast.pomrepositylib.Organization;
import com.crm.comcast.pomrepositylib.OrganizationInfo;

public class CreateOrganisationTest extends BaseAnnotationClass{
	static {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
	}
	
	@Test(groups={"smoke"})
	public void createOrgWithIndustriesTest() throws EncryptedDocumentException, IOException, InterruptedException {
			
		/*Take data from Excel File*/
		String org=flib.getExcelData("organizations",1, 2);		
		String industryName=flib.getExcelData("organizations",1, 3);
		String industryType=flib.getExcelData("organizations",1, 4);
			
		/*home-page*/
		Home h=new Home(driver);
		h.getOrganizationLink().click();
		/*organisation page*/	
		Organization o=new Organization(driver);
		o.getCreateOrganizationLink().click();
		/*create organisation page */	
		String orgname=org+"_"+jlib.getRandomNum(10000);
		CreateOrganizations c=new CreateOrganizations(driver);
		c.getCreateOrganizationTxtBx().sendKeys(orgname);
		c.selectIndustry(industryName);
		c.selectType(industryType);
		c.getSaveBtn().click();
		
		/*organisationInfo page */	
		OrganizationInfo oi=new OrganizationInfo(driver);
		oi.isOrganizationCreated(orgname);
		oi.isIndustryAndTypeCreated(industryName, industryType);
		
	}
	
	@Test(groups={"regression"})
	public void createOrgTest() throws EncryptedDocumentException, IOException{
			
		/*Take data from Excel File*/
		String org=flib.getExcelData("organizations",1, 2);		
			
		/*home-page*/
		Home h=new Home(driver);
		h.getOrganizationLink().click();
		/*organisation page*/	
		Organization o=new Organization(driver);
		o.getCreateOrganizationLink().click();
		
		/*create organisation page */	
		String orgname=org+"_"+jlib.getRandomNum(100);
		CreateOrganizations c=new CreateOrganizations(driver);
		c.getCreateOrganizationTxtBx().sendKeys(orgname);
		c.getSaveBtn().click();
		
		/*organisationInfo page */	
		OrganizationInfo oi=new OrganizationInfo(driver);
		oi.isOrganizationCreated(orgname);
		
	}
		
}
