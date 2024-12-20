package stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;

public class steps {		
	
	WebDriver driver = new EdgeDriver();

	@Given("The user is on the login page")
	public void the_user_is_on_the_login_page() {
		driver.get("http://192.168.99.141:3000");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@When("User should login {string} and {string}")
	public void user_should_login_and(String string, String string2) {
		driver.findElement(By.name("username")).sendKeys("suthirshana.muniyappan@expleogroup.com");
		driver.findElement(By.id("Password")).sendKeys("Suthir");
	}
	
	@When("Clicks the login button")
	public void clicks_the_login_button() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

	}
	
	@Then("The User should be redirected to the dashboard page")
	public void the_user_should_be_redirected_to_the_dashboard_page() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Logout']")).click();
		System.out.println("Login Successful");
	}

	@Then("quit the 1st Browser")
	public void quit_the_1st_browser() {
	    driver.quit();
	}
	
	@When("User enters a invalid {string} and {string}")
	public void user_enters_a_invalid_and(String string, String string2) {
		driver.findElement(By.name("username")).sendKeys("suthirshana@expleogroup.com");
		driver.findElement(By.id("Password")).sendKeys("Suthir");
	}

	@Then("An error msg should be displayed")
	public void an_error_msg_should_be_displayed() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		WebElement error = driver.findElement(By.xpath("//p[text()='Username and password are required']"));
		String text = error.getText();
		System.out.println(text);
	}
	
	@Then("quit the 2nd Browser")
	public void quit_the_2nd_browser() {
	    driver.quit();
	}
	
	@When("The User leaves the {string} and {string} fields empty")
	public void the_user_leaves_the_and_fields_empty(String string, String string2) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(" ");
		driver.findElement(By.id("Password")).sendKeys(" ");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}

	@Then("A valid msg should be displayed")
	public void a_valid_msg_should_be_displayed() {
		System.out.println("No credentials added");	    
	}
	
	@Then("quit the 3rd Browser")
	public void quit_the_3rd_browser() {
	    driver.quit();
	}


	
}
