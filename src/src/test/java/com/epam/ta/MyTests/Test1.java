package com.epam.ta.MyTests;

import com.epam.ta.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {     // аналог githubautomationtest

        private Steps steps;
        private final String USERNAME = "krukaliaksandr";
        private final String PASSWORD = "san9san9";

        @BeforeMethod(description = "Init browser")
        public void setUp()
        {
            steps = new Steps();
            steps.initBrowser();

        }

        @Test
        public void oneCanCreateProject()
        {
            steps.loginGithub(USERNAME, PASSWORD);
            Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
            Assert.assertTrue(steps.currentRepositoryIsEmpty());
        }

        @Test(description = "Login to Github")
        public void oneCanLoginGithub()
        {
            steps.loginGithub(USERNAME, PASSWORD);
            Assert.assertTrue(steps.isLoggedIn(USERNAME));
        }

        @AfterMethod(description = "Stop Browser")
        public void stopBrowser()
        {
            steps.closeDriver();
        }

}
