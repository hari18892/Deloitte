package org.deloitte.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.deloitte.utils.DeloitteDriver;

import java.net.MalformedURLException;

public class Hook extends BaseTest {
    private BaseTest test;

    public Hook(BaseTest test) {
        this.test = test;
    }

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        logger.info("Launching the browser");
        this.driver = DeloitteDriver.getJenkins();
        this.test.driver = this.driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        logger.info("Closing the browser.");
        final byte[] screenshot = driver.getScreenshot();
        scenario.attach(screenshot, "image/png", scenario.getName());
        this.driver.quit();
    }
}
