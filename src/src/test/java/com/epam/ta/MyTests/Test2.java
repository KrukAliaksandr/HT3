package com.epam.ta.MyTests;

import com.epam.ta.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
    private Steps steps;
    private final String USERNAME = "krukaliaksandr";
    private final String PASSWORD = "san9san9";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();

    }

    @Test(description = "Test Gist Creation")
    public void oneCanCreateGist() {
        steps.loginGithub(USERNAME, PASSWORD);
        Assert.assertTrue(steps.createNewGist("Description", "Name", "//SomeText"), "Names doesn't match");
        Assert.assertFalse(steps.deleteNewGist(), "Could not delete gist properly");
    }


    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
