package runner;

import org.junit.runner.RunWith;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\smuniyappan2\\eclipse-workspace\\MavenProject\\"
		+ "src\\test\\resources", 
		glue = {"stepDef"},
		tags = "@All_scenario",
		plugin = {"pretty", "html:target/result.html"},
		dryRun = false
		
		) 
public class TestRunnerClass {

	
}
