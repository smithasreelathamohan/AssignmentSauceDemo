package com.example.assignmentsaucedemo.testcase;

import com.example.assignmentsaucedemo.common.Functions;
import org.junit.jupiter.api.*;
import com.example.assignmentsaucedemo.base.Base;
import static org.junit.jupiter.api.Assertions.*;


public class TC01SuccessfulLoginTest extends Base {

    @Test
    @DisplayName("standard_user Successful login test")
    public void standard_userSuccessfulLoginTest() {
        Functions.login(STANDARD_USER, VALID_PASSWORD);
        String currentUrl = String.valueOf(driver.getCurrentUrl());
        assertTrue(currentUrl.contains("/inventory.html"), "Error: Should redirect to inventory page after successful login");
        logger.info("Logged in successfully");
    }

    @Test
    @DisplayName("problem_user Successful login test")
    public void problem_userSuccessfulLoginTest(){
        Functions.login(PROBLEM_USER, VALID_PASSWORD);
        String currentUrl = String.valueOf(driver.getCurrentUrl());
        assertTrue(currentUrl.contains("/inventory.html"), "Error: Should redirect to inventory page after successful login");
        logger.info("Logged in successfully");
    }


    @Test
    @DisplayName("error_user Successful login test")
    public void error_userSuccessfulLoginTest(){
        Functions.login(ERROR_USER, VALID_PASSWORD);
        String currentUrl = String.valueOf(driver.getCurrentUrl());
        assertTrue(currentUrl.contains("/inventory.html"), "Error: Should redirect to inventory page after successful login");
        logger.info("Logged in successfully");
    }

    @Test
    @DisplayName("visual_user Successful login test")
    public void visual_userSuccessfulLoginTest(){
        Functions.login(VISUAL_USER, VALID_PASSWORD);
        String currentUrl = String.valueOf(driver.getCurrentUrl());
        assertTrue(currentUrl.contains("/inventory.html"), "Error: Should redirect to inventory page after successful login");
        logger.info("Logged in successfully");
    }
}

