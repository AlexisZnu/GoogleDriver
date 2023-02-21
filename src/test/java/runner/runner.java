package runner;

import MainPage.BasePage;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Steps",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
        monochrome = true,
        tags = "@Amazon"
)

public class runner {
    @AfterClass
    public static void closeBrowser(){
        BasePage.closeBrowser();
    }
}
