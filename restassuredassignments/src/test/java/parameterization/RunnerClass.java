package parameterization;

import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\USER\\eclipse-workspace\\restassuredassignments\\src\\test\\resources\\features\\parameterization.feature",
glue="parameterization",
plugin={"pretty","json:target/JSONReports/report.json"}
)
public class RunnerClass {

}

