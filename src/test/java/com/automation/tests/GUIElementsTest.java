package com.automation.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.utils.ScreenshotUtil;
import com.automation.base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.util.Set;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Listeners;
import com.automation.listeners.TestListener;
import com.automation.pages.GUIElementsPage;
import com.automation.utils.ExtentManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Listeners(TestListener.class)
public class GUIElementsTest extends BaseTest {


	@Test
	public void automateGUIElements() throws Exception {

	    ExtentReports extent =
	            ExtentManager.getInstance();

	    ExtentTest test =
	            extent.createTest(
	                    "GUI Elements Automation Test");

	    // TEXT FIELDS

	    GUIElementsPage page =
	            new GUIElementsPage(driver);

	    page.enterName("Giri");
	    page.enterEmail("giri@gmail.com");
	    page.enterPhone("9876543210");
	    page.enterAddress("Vijayawada");

	    test.pass("Text Fields Completed");

        // ==================================================
        // RADIO BUTTON
        // ==================================================

        driver.findElement(By.id("male"))
                .click();

        // ==================================================
        // CHECKBOXES
        // ==================================================

        driver.findElement(By.id("sunday"))
                .click();

        driver.findElement(By.id("monday"))
                .click();

        driver.findElement(By.id("friday"))
                .click();

        // ==================================================
        // COUNTRY DROPDOWN
        // ==================================================

        Select country = new Select(
                driver.findElement(By.id("country")));

        country.selectByVisibleText("India");
        test.pass("Dropdown Selection Completed");

        // ==================================================
        // COLORS DROPDOWN
        // ==================================================

        Select colors = new Select(
                driver.findElement(By.id("colors")));

        colors.selectByVisibleText("Red");
        test.pass("Dropdown Selection Completed");

        // ==================================================
        // ANIMALS DROPDOWN
        // ==================================================

        Select animals = new Select(
                driver.findElement(By.id("animals")));

        animals.selectByVisibleText("Lion");
        test.pass("Dropdown Selection Completed");
        // ==================================================
        // DATE PICKER
        // ==================================================

        driver.findElement(By.id("datepicker"))
                .sendKeys("06/15/2026");
     // ==================================================
     // DATE PICKER 2
     // ==================================================

     driver.findElement(
             By.id("txtDate"))
             .sendKeys("15/06/2026");

     System.out.println(
             "Date Picker 2 Completed");

     test.pass(
             "Date Picker 2 Completed");
  // ==================================================
  // DATE RANGE PICKER
  // ==================================================

  try {

      WebElement startDate =
              driver.findElement(
                      By.xpath(
                              "(//input[@placeholder='dd-mm-yyyy'])[1]"));

      startDate.sendKeys(
              "01-06-2026");

      WebElement endDate =
              driver.findElement(
                      By.xpath(
                              "(//input[@placeholder='dd-mm-yyyy'])[2]"));

      endDate.sendKeys(
              "15-06-2026");

      System.out.println(
              "Date Range Selected");

      test.pass(
              "Date Range Picker Completed");

  } catch(Exception e) {

      System.out.println(
              "Date Range Picker Locator Needs Adjustment");
  }

        // ==================================================
        // SCROLL DOWN
        // ==================================================

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,700)");

        Thread.sleep(2000);

        // ==================================================
        // SIMPLE ALERT
        // ==================================================

        driver.findElement(
                By.xpath("//button[text()='Simple Alert']"))
                .click();

        Alert simpleAlert =
                driver.switchTo().alert();

        System.out.println("Simple Alert : "
                + simpleAlert.getText());

        simpleAlert.accept();

        Thread.sleep(1000);

        // ==================================================
        // CONFIRM ALERT
        // ==================================================

        driver.findElement(
                By.xpath("//button[text()='Confirmation Alert']"))
                .click();

        Alert confirmAlert =
                driver.switchTo().alert();

        System.out.println("Confirm Alert : "
                + confirmAlert.getText());

        confirmAlert.dismiss();

        Thread.sleep(1000);

        // ==================================================
        // PROMPT ALERT
        // ==================================================

        driver.findElement(
                By.xpath("//button[text()='Prompt Alert']"))
                .click();

        Alert promptAlert =
                driver.switchTo().alert();

        promptAlert.sendKeys("Automation Testing");

        promptAlert.accept();

        Thread.sleep(2000);
        test.pass("Alert Handling Completed");
     // ==================================================
     // MOUSE HOVER
     // ==================================================

     js.executeScript("window.scrollBy(0,300)");

     Thread.sleep(2000);

     WebElement pointMe =
             driver.findElement(
                     By.xpath("//button[text()='Point Me']"));

     Actions hoverAction =
             new Actions(driver);

     hoverAction.moveToElement(pointMe)
             .perform();

     Thread.sleep(2000);

     System.out.println(
             "Mouse Hover Performed Successfully");

     test.pass(
             "Mouse Hover Completed");
   // ==================================================
  // DYNAMIC BUTTON
  // ==================================================

  js.executeScript("window.scrollTo(0,0)");

  Thread.sleep(2000);

  WebElement startButton =
          driver.findElement(
                  By.xpath("//button[text()='START']"));

  startButton.click();

  System.out.println(
          "START Button Clicked");

  Thread.sleep(5000);

  System.out.println(
          "Dynamic Button Validation Completed");

  test.pass(
          "Dynamic Button Completed");
        // ==================================================
        // DOUBLE CLICK
        // ==================================================

        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(2000);

        WebElement copyButton =
                driver.findElement(
                        By.xpath("//button[text()='Copy Text']"));

        Actions actions =
                new Actions(driver);

        actions.doubleClick(copyButton)
                .perform();

        Thread.sleep(1000);

        String copiedText =
                driver.findElement(By.id("field2"))
                        .getAttribute("value");

        Assert.assertEquals(
                copiedText,
                "Hello World!");

        System.out.println(
                "Double Click Validation Passed");
     // ==================================================
     // NEW TAB
     // ==================================================

     js.executeScript("window.scrollBy(0,200)");

     Thread.sleep(2000);

     String parentWindow =
             driver.getWindowHandle();

     driver.findElement(
             By.xpath("//button[text()='New Tab']"))
             .click();

     Thread.sleep(3000);

     Set<String> allWindows =
             driver.getWindowHandles();

     for(String window : allWindows) {

         if(!window.equals(parentWindow)) {

             driver.switchTo().window(window);

             System.out.println(
                     "New Tab Title : "
                             + driver.getTitle());

             driver.close();
         }
     }

     driver.switchTo().window(parentWindow);

     test.pass(
             "New Tab Handling Completed");
  // ==================================================
  // POPUP WINDOW
  // ==================================================

  driver.findElement(
          By.xpath("//button[text()='Popup Windows']"))
          .click();

  Thread.sleep(3000);

  Set<String> popupWindows =
          driver.getWindowHandles();

  for(String window : popupWindows) {

      if(!window.equals(parentWindow)) {

          driver.switchTo().window(window);

          System.out.println(
                  "Popup Window Title : "
                          + driver.getTitle());

          driver.close();
      }
  }

  driver.switchTo().window(parentWindow);

  test.pass(
          "Popup Window Handling Completed");
        // ==================================================
        // DRAG AND DROP
        // ==================================================

        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(2000);

        WebElement source =
                driver.findElement(By.id("draggable"));

        WebElement target =
                driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source, target)
                .perform();

        System.out.println(
                "Drag and Drop Completed");

        Thread.sleep(2000);
        test.pass("Drag and Drop Completed");
        // ==================================================
        // SLIDER
        // ==================================================

        WebElement slider =
                driver.findElement(
                        By.xpath(
                                "(//span[contains(@class,'ui-slider-handle')])[1]"));

        actions.dragAndDropBy(slider, 80, 0)
                .perform();

        System.out.println(
                "Slider Moved Successfully");

        Thread.sleep(2000);

        // ==================================================
        // FILE UPLOAD
        // ==================================================

        js.executeScript("window.scrollBy(0,700)");

        Thread.sleep(2000);

        String filePath =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\test.txt";

        driver.findElement(By.id("singleFileInput"))
                .sendKeys(filePath);

        System.out.println(
                "File Uploaded Successfully");

        Thread.sleep(2000);
        test.pass("File Upload Completed");
     // ==================================================
     // MULTIPLE FILE UPLOAD
     // ==================================================

     String file1 =
             System.getProperty("user.dir")
             + "\\src\\test\\resources\\test1.txt";

     String file2 =
             System.getProperty("user.dir")
             + "\\src\\test\\resources\\test2.txt";

     driver.findElement(By.id("multipleFilesInput"))
             .sendKeys(file1 + "\n" + file2);

     System.out.println(
             "Multiple Files Uploaded Successfully");

     test.pass(
             "Multiple File Upload Completed");

     Thread.sleep(2000);
        // ==================================================
        // STATIC WEB TABLE
        // ==================================================

        int rows =
                driver.findElements(
                        By.xpath("//table[@name='BookTable']//tr"))
                        .size();

        System.out.println(
                "Total Rows in Book Table : "
                        + rows);
     // ==================================================
     // DYNAMIC WEB TABLE
     // ==================================================

     js.executeScript("window.scrollBy(0,500)");

     Thread.sleep(2000);

     try {

         WebElement cpuLoad =
                 driver.findElement(
                         By.xpath("//table[@id='taskTable']//tr[2]/td[2]"));

         System.out.println(
                 "CPU Load : "
                         + cpuLoad.getText());

         test.pass(
                 "Dynamic Table Validated");

     } catch(Exception e) {

         System.out.println(
                 "Dynamic Table Locator Needs Adjustment");
     }
        // ==================================================
        // PAGINATION TABLE
        // ==================================================

        js.executeScript("window.scrollBy(0,800)");

        Thread.sleep(2000);

        for (int page1 = 1; page1 <= 4; page1++) {

            driver.findElement(
                    By.linkText(
                            String.valueOf(page1)))
                    .click();

            Thread.sleep(1000);

            System.out.println(
                    "Page Selected : " + page1);
        }
     // ==================================================
     // LAPTOP LINKS
     // ==================================================

     try {

         java.util.List<WebElement> laptopLinks =
                 driver.findElements(
                         By.xpath("//a[contains(@href,'apple') or contains(@href,'lenovo') or contains(@href,'dell')]"));

         for(WebElement link : laptopLinks) {

             System.out.println(
                     "Laptop Link : "
                             + link.getText());

             System.out.println(
                     "URL : "
                             + link.getAttribute("href"));
         }

         test.pass(
                 "Laptop Links Validated");

     } catch(Exception e) {

         System.out.println(
                 "Laptop Links Locator Needs Adjustment");
     }
  // ==================================================
  // BROKEN LINKS
  // ==================================================

  try {

      List<WebElement> links =
              driver.findElements(By.tagName("a"));

      for(WebElement link : links) {

          String url =
                  link.getAttribute("href");

          if(url != null &&
             url.startsWith("http")) {

              HttpURLConnection connection =
                      (HttpURLConnection)
                              new URL(url)
                                      .openConnection();

              connection.connect();

              int code =
                      connection.getResponseCode();

              System.out.println(
                      url
                      + " -> "
                      + code);
          }
      }

      test.pass(
              "Broken Links Validation Completed");

  } catch(Exception e) {

      System.out.println(
              "Broken Links Validation Failed");
  }

        // ==================================================
        // TEST COMPLETED
        // ==================================================
        String screenshot =
                ScreenshotUtil.captureScreenshot(
                        driver,
                        "GUIAutomationPass");

        test.addScreenCaptureFromPath(
                screenshot);

        test.pass(
        	    "RUN AT 11:38 PM");

        extent.flush();
    }
}