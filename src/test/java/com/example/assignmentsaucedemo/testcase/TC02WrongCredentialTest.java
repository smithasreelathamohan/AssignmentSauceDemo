package com.example.assignmentsaucedemo.testcase;

import com.example.assignmentsaucedemo.base.Base;
import com.example.assignmentsaucedemo.common.Functions;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TC02WrongCredentialTest extends Base {

    @Test
    @DisplayName("Invalid password")
    public void invalid_usernameLoginTest() {
        logger.info("Validating invalid password login test...");
        Functions.login(STANDARD_USER, INVALID_PASSWORD);
        boolean error = driver.findElement(LOGIN_ERROR_MSG).isDisplayed();
        assertTrue(error, "Error: User should not be able to login and error message should be displayed");
        logger.info("Cannot login. Password is invalid");
    }

    @Test
    @DisplayName("Invalid username")
    public void invalid_passwordLoginTest() {
        logger.info("Validating invalid username login test...");
        Functions.login(INVALID_USER, VALID_PASSWORD);
        boolean error = driver.findElement(LOGIN_ERROR_MSG).isDisplayed();
        assertTrue(error, "Error: User should not be able to login and error message should be displayed");
        logger.info("Cannot login. Username is invalid");
    }

    @Test
    @DisplayName("Wrong navigation")
    public void invalid_user_navigationLoginTest() {
        logger.info("Validating url navigation on invalid entries...");
        Functions.login(INVALID_USER, INVALID_PASSWORD);
        String currentUrl = String.valueOf(driver.getCurrentUrl());
        assertFalse(currentUrl.contains("/inventory.html"), "Error: Should not be redirect to inventory page");
        logger.info("Cannot login");
    }

    @Test
    @DisplayName("Invalid error message")
    public void invalid_errormessageLoginTest()  {
        logger.info("Validating error message");
        Functions.login(INVALID_USER, INVALID_PASSWORD);
        String ERROR_WRONG_MESSAGE= "Epic sadface: Username and password do not match any user in this service";
        boolean error_msg = driver.findElement(LOGIN_ERROR_MSG).getText().equals(ERROR_WRONG_MESSAGE);
        assertTrue(error_msg, "Error: Wrong error message displayed");
        logger.info("Error message is correct");
    }




}

