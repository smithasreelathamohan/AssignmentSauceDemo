package com.example.assignmentsaucedemo.common;

import com.example.assignmentsaucedemo.base.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Functions extends Base {

    public static void login(String username, String password) {
        driver.findElement(SAUCE_USERNAME).clear();
        driver.findElement(SAUCE_USERNAME).sendKeys(username);
        driver.findElement(SAUCE_PASSWORD).clear();
        driver.findElement(SAUCE_PASSWORD).sendKeys(password);
        driver.findElement(SAUCE_LOGIN_BTN).click();
    }

    public static void waitForInventoryList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAUCE_PAGE_INVENTORY));
    }

    public static void takeScreenshot(String className, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

            Path dir = Paths.get("screenshots", className);
            Files.createDirectories(dir);

            Path dest = dir.resolve(testName + "_" + timestamp + ".png");
            Files.copy(src.toPath(), dest);

            System.out.println("Screenshot saved: " + dest);

        } catch (IOException e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

}
