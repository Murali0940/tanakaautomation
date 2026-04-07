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
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String path = ScreenshotUtil.capture(BaseClass.driver, result.getName());

        if (path != null) {
            test.addScreenCaptureFromPath(path);
        }
    }

    public void onFinish(ITestContext context) {

        extent.flush();

        // ✅ SEND EMAIL AFTER EXECUTION
        EmailUtil.sendReport();
    }

}
