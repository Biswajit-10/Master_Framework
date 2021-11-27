package com.crm.comcast.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;


import com.crm.comcast.pomrepositylib.Home;
import com.crm.comcast.pomrepositylib.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseAnnotationClass {
	public FileUtility flib=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility  wlib=new WebDriverUtility();
	public WebDriver driver;
	static {
		WebDriverManager.chromedriver().setup();		
		WebDriverManager.firefoxdriver().setup();		
		WebDriverManager.iedriver().setup();		
	}
	
	@Parameters(value="BROWSER")//this name same as xml parameter name
	@BeforeClass(groups={"smoke","regression"})
	public void configBc( /* String BROWSER */ ) throws IOException {//this name can be anything but same as inside method name
		String BROWSER =flib.getPropertyData("BROW");
		/*Open Browser*/
		if(BROWSER.equals("chrome"))
		{        
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
	}
	@BeforeMethod(groups={"smoke","regression"})
	public void configBm() throws IOException {
		/*Take data from Property File*/

		String url =flib.getPropertyData("url");
		String un = flib.getPropertyData("un");
		String pwd =flib.getPropertyData("pwd");
		
		/*Log-in*/

		wlib.implicitWait(driver, 10);
		driver.get(url);		
		Login l=new Login(driver);
		l.loginToApp(un, pwd);	
	}
	@AfterMethod(groups={"smoke","regression"})
	public void configAm() throws IOException {
		/*log-out*/
		Home h=new Home(driver);
		h.logOut();
	}
	@AfterClass(groups={"smoke","regression"})
	public void configAc() {
		driver.quit();
	}
}
