package base;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:test-output/cucumber-reports/report_rerun1.html" }, features = {
		"@test-output/failedTests.txt" }, glue = { "stepDefinitions" })

//"json:test-output/cucumber-reports/cucumber.json"

// This runner runs only failed scenarios present in file failedTests.txt generated after main run by TestRunner
public class FailedTestRunner extends AbstractTestNGCucumberTests {
	// - This runner can be executed conditionally in Jenkins for rerunning failed
	// tests if file failedTests.txt exists
	// - testng.xml file (if configured) can include this runner as well under
	// <class> tag
}
