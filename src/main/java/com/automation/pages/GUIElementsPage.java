package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GUIElementsPage {

    WebDriver driver;

    public GUIElementsPage(WebDriver driver) {

        this.driver = driver;
    }

    By name = By.id("name");

    By email = By.id("email");

    By phone = By.id("phone");

    By address = By.xpath("//textarea");

    public void enterName(String value) {

        driver.findElement(name)
                .sendKeys(value);
    }

    public void enterEmail(String value) {

        driver.findElement(email)
                .sendKeys(value);
    }

    public void enterPhone(String value) {

        driver.findElement(phone)
                .sendKeys(value);
    }

    public void enterAddress(String value) {

        driver.findElement(address)
                .sendKeys(value);
    }
}