package com.example.assignmentsaucedemo.base;


import com.example.assignmentsaucedemo.common.Utility;
import com.example.assignmentsaucedemo.common.Pages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class Base extends Pages {

    protected static Logger logger = Logger.getLogger(Base.class.getName());

    protected static String BASE_URL = "https://www.saucedemo.com/";
    protected static String STANDARD_USER ="standard_user";
    protected static String PROBLEM_USER     = "problem_user";
    protected static String PERFORMANCE_USER = "performance_glitch_user";
    protected static String ERROR_USER      = "error_user";
    protected static String VISUAL_USER      = "visual_user";

    protected static String VALID_PASSWORD ="secret_sauce";
    protected static String INVALID_PASSWORD ="error_sauce";
    protected static String INVALID_USER ="test";

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    private static boolean checkHeadless() {
        String ciEnv = System.getenv("CI");
        return "true".equalsIgnoreCase(ciEnv);
    }

    @BeforeAll
    static void setUp(TestInfo testInfo) {
        Utility.cleanScreenshots(testInfo);
    }

    @BeforeEach
    void setupClass() {
        ChromeOptions options = new ChromeOptions();
        boolean headless = checkHeadless();
        if (headless) {
            options.addArguments("--headless");
        }
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(BASE_URL);
        logger.info("Navigate to browser URL: " + BASE_URL);
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {

        Utility.takeScreenshot(testInfo);

        if (driver != null) {
            driver.quit();
            logger.info("Browser quit");
        }
    }

}
