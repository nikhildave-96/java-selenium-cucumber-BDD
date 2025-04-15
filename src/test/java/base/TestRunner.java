package base;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Running test(s) tagged with a tag --> tags = "@tagName1 or @tagName2 or @tagName3" 
// or is logical OR operator, test(s) found if any with any of the specified matching tags will be executed.

// Running a test associated with multiple tags --> tags = "@tagName1 and @tagName2"
// and is logical AND operator, only test(s) found with all specified matching tags will be executed.

// Running feature file(s) instead of running all features --> 
// features = { "src/test/resources/features/AccountPageTest.feature", "src/test/resources/features/HomePageTest.feature" }
// features option take file-system-path

// glue option takes the package name(s) [as it looks for actual compiled classes] and not the file-system-path inside which step definitions are written (automatically searches the nested packages), 
// can also take a comma-separated list of different package names inside which step definitions are written.

//failed scenarios gets written to failedTests.txt by rerun plugin which will be further retried by FailedTestRunner.

@CucumberOptions(plugin = { "pretty", "html:test-output/cucumber-reports/report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:test-output/failedTests.txt" }, features = {
				"src/test/resources/features" }, glue = { "stepDefinitions" }, tags = "@oc_device_Windows11x64")

// TestNG based cucumber runner
public class TestRunner extends AbstractTestNGCucumberTests {

}
