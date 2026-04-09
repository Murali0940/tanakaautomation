package org.utils;

import com.aventstack.extentreports.ExtentTest;

public class LogUtil {

    public static ExtentTest test;

    public static void info(String message) {
        if (test != null) {
            test.info(message);
        }
        System.out.println("INFO: " + message);
    }

    public static void pass(String message) {
        if (test != null) {
            test.pass(message);
        }
        System.out.println("PASS: " + message);
    }

    public static void fail(String message) {
        if (test != null) {
            test.fail(message);
        }
        System.out.println("FAIL: " + message);
    }

}
