package runner;

import org.junit.runner.RunWith;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\TVDI-00\\eclipse-workspace\\mavenProject\\"
		+ "src\\test\\resources\\LoginPage.feature", 
		glue = {"stepDef"},
		plugin = {"pretty", "html:target/result.html"},
		dryRun = false
		
		) 
public class TestRunnerClass {

	
}
