package com.example.assignmentsaucedemo.common;
import org.openqa.selenium.By;

public class Pages {
    public static final By SAUCE_USERNAME    = By.id("user-name");
    public static final By SAUCE_PASSWORD    = By.id("password");
    public static final By SAUCE_LOGIN_BTN   = By.id("login-button");
    protected static final By SAUCE_PAGE_INVENTORY   = By.cssSelector(".inventory_list");
    protected static final By LOGIN_ERROR_MSG   = By.cssSelector("[data-test='error']");
    protected static final String ERROR_WRONG_CRED = "Epic sadface: Username and password do not match any user in this service";
}
