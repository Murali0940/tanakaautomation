package org.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    public static ExtentReports extent;
    public static String reportPath;

    public static ExtentReports getInstance() {

        if (extent == null) {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            reportPath = System.getProperty("user.dir") + "\\reports\\extent-report_" + timeStamp + ".html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }

}
