package com.epam.ta.MyTests;

import com.epam.ta.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test3 {
    private Steps steps;
    private final String USERNAME = "krukaliaksandr";
    private final String PASSWORD = "san9san9";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }
    @Test(description = "Test Gist Creation")
    public void oneCanMakeASearch()
    {
        steps.loginGithub(USERNAME, PASSWORD);
        Assert.assertTrue(steps.makeNewSearchRequest("TestAutomation"),"Failed to get request with java projects");
        Assert.assertTrue(steps.CheckFirstResult(),"Failed to get a Repo from the first link");
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }


}
