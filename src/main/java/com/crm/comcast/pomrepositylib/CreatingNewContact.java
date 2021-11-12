package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;
/**
 * 
 * @author Biswajit
 *
 */
public class CreatingNewContact {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLink;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="lastname")
	private WebElement lastNameTxtBx;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement OrganizationNameIcon;
	
	public void clickCreateContactLinkEnterLastNameAndClickLookUpIcon(String lastName) {
		createContactLink.click();
		lastNameTxtBx.sendKeys(lastName);
		OrganizationNameIcon.click();
	}
	
	public void clickCreateContactLinkEnterLastName(String lastName) {
		createContactLink.click();
		lastNameTxtBx.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void switchWindowToLookUp () {
		WebDriverUtility wu=new WebDriverUtility();
		wu.moveToWindow(driver,"Accounts&action" );
		
	}	
	
	public CreatingNewContact(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public WebElement getCreateContactLink() {
		return createContactLink;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getLastNameTxtBx() {
		return lastNameTxtBx;
	}

	public WebElement getOrganizationNameIcon() {
		return OrganizationNameIcon;
	}
	

}
