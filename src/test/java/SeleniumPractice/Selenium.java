package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://192.168.99.141:3000/");
		driver.findElement(By.name("username")).sendKeys("suthirshana.muniyappan@expleogroup.com");
		driver.findElement(By.id("Password")).sendKeys("Suthir");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//button[text()='Logout']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
	

}
