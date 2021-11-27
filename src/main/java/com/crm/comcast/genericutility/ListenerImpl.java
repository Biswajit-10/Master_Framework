package com.crm.comcast.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpl implements ITestListener {
	ExtentTest test;
	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Object obj = result.getInstance();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver")
					.get(obj);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + methodName + ".PNG");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName() + "is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./Extent Report/" + context.getName());
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Vtiger CRM");
		spark.config().setReportName("Automation Execution Report");

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", System.getProperty("os.name"));

		FileUtility fLib = new FileUtility();
		try {
			report.setSystemInfo("Testing url", fLib.getPropertyData("url"));
			report.setSystemInfo("Browser", fLib.getPropertyData("BROW"));
			report.setSystemInfo("Reporter Name", "BISWAJIT");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
