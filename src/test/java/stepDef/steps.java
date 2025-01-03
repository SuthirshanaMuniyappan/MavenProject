package stepDef;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

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
	public void user_should_login_and(String username, String password) throws Exception {
		
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(username);  //"suthirshana.muniyappan@expleogroup.com"
		
		Thread.sleep(3000);
		driver.findElement(By.id("Password")).sendKeys(password); //"Suthir"
	}

	@When("Clicks the login button")
	public void clicks_the_login_button() throws Throwable {
		
		Actions actions = new Actions(driver);
		
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		WebElement login_btn = driver.findElement(By.xpath("//button[@type='submit']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", login_btn);
		actions.click(login_btn).build().perform();
//		login_btn.click();
	}

	@Then("The User should be redirected to the dashboard page")
	public void the_user_should_be_redirected_to_the_dashboard_page() throws InterruptedException {

		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement logout_btn = driver.findElement(By.xpath("//button[text()='Logout']"));
		//		actions.moveToElement(logout_btn).click().build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout_btn);
		System.out.println("Login Successful");

	}

	@Then("quit the 1st Browser")
	public void quit_the_1st_browser() {
		System.out.println("**********Scenario 1st completed successfully***********");	 
		driver.quit();
	}

	@When("User enters a invalid {string} and {string}")
	public void user_enters_a_invalid_and(String username, String Password) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("suthirshana@expleogroup.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("Password")).sendKeys("Suthir");
	}

	@Then("An error msg should be displayed")
	public void an_error_msg_should_be_displayed() throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		Thread.sleep(7000);
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;             
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);          
		File destinationFile = new File("screenshot.png");            
		FileUtils.copyFile(srcFile, destinationFile);
		
		
		//WebElement error = driver.findElement(By.xpath("//p[text()='Invalid username or password']"));
		//String text = error.getText();
		//System.out.println(text);
	}

	@Then("quit the 2nd Browser")
	public void quit_the_2nd_browser() {
		System.out.println("Scenario 2nd completed successfully");	 
		driver.quit();
	}

	@When("The User leaves the {string} and {string} fields empty")
	public void the_user_leaves_the_and_fields_empty(String username, String Password) throws InterruptedException {
		
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
		System.out.println("Scenario 3rd completed successfully");	 
		driver.quit();
	}

	@Then("quit the 4th Browser")
	public void quit_the_4th_browser() {
		System.out.println("Scenario 4th completed successfully");	 
		driver.quit();
	}
	
//5th Scenario>>>>
	
	@Then("Validate the dashboard page title")
	public void validate_the_dashboard_page_title() throws Throwable {
	    
		Thread.sleep(2000);
		WebElement tile = driver.findElement(By.xpath("//p[@class='text-lg font-bold text-white']"));
		String page_title = tile.getText();
		Assert.assertEquals("ExpleoSurance", page_title);
		System.out.println(page_title+" is validated successfully");
		
	}

	@Then("quit the 5th Browser")
	public void quit_the_5th_browser() {
		System.out.println("Scenario 5th completed successfully");	 
		driver.quit();
	}


	



}
