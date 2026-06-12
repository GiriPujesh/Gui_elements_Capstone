
package com.automation.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.base.BaseTest;
import com.automation.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println(
                "STARTED : "
                + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println(
                "PASSED : "
                + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                "FAILED : "
                + result.getName());

        System.out.println(
                result.getThrowable());

        try {

            String screenshot =
                    ScreenshotUtil.captureScreenshot(
                            BaseTest.driver,
                            "FAIL_" + result.getName());

            System.out.println(
                    "Screenshot Saved : "
                    + screenshot);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println(
                "Execution Completed");
    }
}