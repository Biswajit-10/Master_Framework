package com.crm.comcast.contactstest;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.FileUtility;

public class MVNCMDTest {

	static{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
	}
	static WebDriver driver;
	@Test
	public void create() throws EncryptedDocumentException, IOException {
		FileUtility f=new FileUtility();
		String org=f.getExcelData("organizations", 1, 2);
		Random random=new Random();
		int i=random.nextInt();
		String orgname=org+" "+i;
		
		String BROWSER =System.getProperty("Browser");
		System.out.println(BROWSER);
		String url =System.getProperty("url");
		String un = System.getProperty("username");
		String pwd =System.getProperty("password");
		if(BROWSER.equals("chrome"))
		{        
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		FileUtility f1=new FileUtility();
		String industry=f1.getExcelData("organizations", 1, 3);
		WebElement e = driver.findElement(By.name("industry"));
		Select s=new Select(e);
		s.selectByVisibleText(industry);
		
		
		WebElement e1 = driver.findElement(By.name("accounttype"));
		Select s1=new Select(e1);
		String type=f1.getExcelData("organizations", 1, 4);
		s1.selectByVisibleText(type);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains(orgname))
			System.out.println("organisation is created successfully");
		else
			System.out.println("organisation is not created ");
		driver.close();
	}
	
}
