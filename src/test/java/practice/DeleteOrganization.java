package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.pomrepositylib.Home;

public class DeleteOrganization extends BaseAnnotationClass {
	@Test	
	public void delete()  {
		Home h=new Home(driver);
		h.getOrganizationLink().click();

		try {
//			driver.findElement(By.xpath("//a[.='HDFC 15']/parent::td/parent::tr/td[8]/a[2]")).click();
			driver.findElement(By.xpath("//a[.='HDFC 71']/ancestor::tr/td[8]/a[2]")).click();
			Alert a=driver.switchTo().alert();
			a.accept();
		}catch (Exception e) {
			System.out.println("Organization is not present");
		}

	}
}
