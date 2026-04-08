package org.listeners;

import org.testng.*;
import com.aventstack.extentreports.*;

import org.base.BaseClass;
import org.utils.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        LogUtil.test = test;
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String path = ScreenshotUtil.capture(BaseClass.page, result.getName());

        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ Test Skipped: " + result.getName());

        test.skip("Test Skipped");
    }

    public void onFinish(ITestContext context) {
        extent.flush();
        EmailUtil.sendReport();
    }
}