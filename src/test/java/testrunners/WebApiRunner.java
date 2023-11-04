package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

//run class with testNg
@RunWith(Cucumber.class)
@CucumberOptions(
        /* This feature and glue is for execution of API */
        features = {"src/test/resources/WebApiFeatures"},
        glue = {"apphooks","stepdefinations"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
/*This class is used to achieve parallel execution */
public class WebApiRunner extends AbstractTestNGCucumberTests {

}
