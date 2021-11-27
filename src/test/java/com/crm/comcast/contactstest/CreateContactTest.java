package com.crm.comcast.contactstest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.pomrepositylib.ContactInformation;
import com.crm.comcast.pomrepositylib.CreateOrganizations;
import com.crm.comcast.pomrepositylib.CreatingNewContact;
import com.crm.comcast.pomrepositylib.Home;
import com.crm.comcast.pomrepositylib.Organization;
import com.crm.comcast.pomrepositylib.OrganizationInfo;

public class CreateContactTest extends BaseAnnotationClass{
	
	@Test(groups={"smoke"})
	public void createContTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		/*Take data from Excel File*/
		String org=flib.getExcelData("organizations",1, 2);		
		
		/*home-page*/
		Home h=new Home(driver);
		h.getOrganizationLink().click();
		/*organisation page*/	
		Organization o=new Organization(driver);
		o.getCreateOrganizationLink().click();
		
		/*create organisation page */	
		String orgname=org+"_"+jlib.getRandomNum(1000);
		CreateOrganizations c=new CreateOrganizations(driver);
		c.getCreateOrganizationTxtBx().sendKeys(orgname);
		c.getSaveBtn().click();
		
		/*organisationInfo page */	
		OrganizationInfo oi=new OrganizationInfo(driver);
		oi.isOrganizationCreated(orgname);
		
		/*create contacts*/  /*Explicit wait here*/
		WebElement element = h.getContactsLink();
		wlib.explicitWait(driver,element , 10);
		element.click();
		
		/*Creating New Contact page */
		CreatingNewContact cnc=new CreatingNewContact(driver);
		String lastname=flib.getExcelData("contacts",1, 4);
		cnc.clickCreateContactLinkEnterLastName(lastname);
			
		/* ContactInformationpage  */
		ContactInformation cip=new ContactInformation(driver);
		cip.isContactCreated( lastname);
	}
	
	@Test(groups={"regression"})
	public void createCont2Test() throws EncryptedDocumentException, IOException, InterruptedException {
		
		/*Take data from Excel File*/
		String org=flib.getExcelData("organizations",1, 2);		
		
		/*home-page*/
		Home h=new Home(driver);
		h.getOrganizationLink().click();
		/*organisation page*/	
		Organization o=new Organization(driver);
		o.getCreateOrganizationLink().click();
		
		/*create organisation page */	
		String orgname=org+"_"+jlib.getRandomNum(1000);
		CreateOrganizations c=new CreateOrganizations(driver);
		c.getCreateOrganizationTxtBx().sendKeys(orgname);
		c.getSaveBtn().click();
		
		/*organisationInfo page */	
		OrganizationInfo oi=new OrganizationInfo(driver);
		Thread.sleep(5000);
		oi.isOrganizationCreated(orgname);
		
		/*create contacts*/
		WebElement element = h.getContactsLink();
		wlib.explicitWait(driver,element , 10);
		element.click();
		
		/*Creating New Contact page */
		CreatingNewContact cnc=new CreatingNewContact(driver);
		String lastname=flib.getExcelData("contacts",1, 4);
		cnc.clickCreateContactLinkEnterLastName(lastname);
			
		/* ContactInformationpage  */
		ContactInformation cip=new ContactInformation(driver);
		cip.isContactCreated(lastname);
	}
}
