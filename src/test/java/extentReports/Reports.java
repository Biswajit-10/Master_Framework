package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
//	Remember 3 classes 
//	1.ExtentReports	2.ExtentSparkReporter	3.ExtentTest
	
	public static void main(String[] args) {
		ExtentReports report=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("./Extent Report/report.html");
		report.attachReporter(spark);//without this not working
		ExtentTest logger = report.createTest("i am a test method");
		logger.log(Status.INFO,"start");
		
		report.flush();
	}

}
