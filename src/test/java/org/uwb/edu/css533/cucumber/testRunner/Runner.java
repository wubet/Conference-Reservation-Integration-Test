package org.uwb.edu.css533.cucumber.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
//        plugin = {"pretty", "html:out/htmlReport.html"},
        glue = {"org.uwb.edu.css533.cucumber"},
        tags = "@SmokeTest",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "json:target/cucumber-reports/CucumberTestReport.json"}
        )
public class Runner {

//    private TestNGCucumberRunner testNGCucumberRunner;
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass() {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//    @Test(groups = "cucumber", description = "Run Cucumber Features.", dataProvider = "scenarios")
//    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
//        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
//    }
//    @DataProvider
//    public Object[][] scenarios() {
//        return testNGCucumberRunner.provideScenarios();
//    }
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() {
//        testNGCucumberRunner.finish();
//    }
}
