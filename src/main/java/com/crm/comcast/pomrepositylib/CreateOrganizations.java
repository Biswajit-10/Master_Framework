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
public class CreateOrganizations {

	@FindBy(name="accountname")
	private WebElement createOrganizationTxtBx;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	public void createNewOrganization(String organizationName) {
		createOrganizationTxtBx.sendKeys(organizationName);
		saveBtn.click();
	}
	
	public void createNewOrganizationWithIndustryAndType(String organizationName,String industryName,String industryType) {
		createOrganizationTxtBx.sendKeys(organizationName);
		selectIndustry(industryName);
		selectType(industryType);
		saveBtn.click();
	}
	
	public void selectIndustry(String industryName) {
		WebDriverUtility wu=new WebDriverUtility();
		wu.select(industryDropDown, industryName);
	}
	
	public void selectType(String industryType) {
		WebDriverUtility wu=new WebDriverUtility();
		wu.select(typeDropDown, industryType);
	}
		

	
	public CreateOrganizations(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	public WebElement getCreateOrganizationTxtBx() {
		return createOrganizationTxtBx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
