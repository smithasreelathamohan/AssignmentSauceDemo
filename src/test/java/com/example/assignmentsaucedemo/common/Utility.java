package com.example.assignmentsaucedemo.common;

import com.example.assignmentsaucedemo.base.Base;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility extends Base {

    public static void cleanScreenshots(TestInfo testInfo) {
        try {
            String className = testInfo.getTestClass()
                    .map(Class::getSimpleName)
                    .orElse("UnknownClass");
            Path screenshotsDir = Paths.get("screenshots", className);

            if (Files.exists(screenshotsDir)) {
                // delete all files inside the folder
                Files.walk(screenshotsDir)
                        .sorted(java.util.Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                Files.createDirectories(screenshotsDir);
                logger.info("Screenshots folder ready");
            }

            // recreate empty folder
            Files.createDirectories(screenshotsDir);
            logger.info("Screenshots folder ready");

        } catch (IOException e) {
            logger.info("Screenshots folder ready: " + e.getMessage());
        }
    }

    public static void takeScreenshot(TestInfo testInfo) {
        try {
            String className = testInfo.getTestClass()
                    .map(Class::getSimpleName)
                    .orElse("UnknownClass");

            String testName = testInfo.getTestMethod()
                    .map(java.lang.reflect.Method::getName)
                    .orElse("UnknownTest");
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
