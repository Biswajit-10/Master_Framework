package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Biswajit
 *
 */
public class Contacts {
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactsLink;   //   which is a image
	
	public Contacts(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateContactsLink() {
		return createContactsLink;
	}
	
}
