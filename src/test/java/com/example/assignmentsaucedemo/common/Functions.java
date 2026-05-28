package com.example.assignmentsaucedemo.common;

import com.example.assignmentsaucedemo.base.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Functions extends Base {

    public static void login(String username, String password) {
        driver.findElement(SAUCE_USERNAME).clear();
        driver.findElement(SAUCE_USERNAME).sendKeys(username);
        driver.findElement(SAUCE_PASSWORD).clear();
        driver.findElement(SAUCE_PASSWORD).sendKeys(password);
        driver.findElement(SAUCE_LOGIN_BTN).click();
        logger.info("Logging in to the system...");
    }

    public static void waitForInventoryList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAUCE_PAGE_INVENTORY));
        logger.info("Waiting for the inventory list...");
    }

}
