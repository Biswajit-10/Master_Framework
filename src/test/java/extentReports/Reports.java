package extentReports;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
//	Remember 3 classes 
//	1.ExtentReports	2.ExtentSparkReporter	3.ExtentTest
	@Test
	public void extent() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./Extent Report/report.html");
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);//without this not working
		ExtentTest logger = report.createTest("i am a test method");
		logger.log(Status.INFO,"start");
		logger.log(Status.INFO,"end");
		
		Reporter.log("testng");
		report.flush();
	}

}
