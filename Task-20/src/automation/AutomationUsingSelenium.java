package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationUsingSelenium {
	public static void main(String[] args) {
		
		// Initialise Webdriver
		WebDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		// navigate to datepicker.com
		
		driver.navigate().to("https://jqueryui.com/datepicker/");
		// wait the driver to load
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//switch to iframe
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		// next month of the date picker 
		WebElement datePicker = driver.findElement(By.cssSelector("input.hasDatepicker"));
		
		datePicker.click();
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		// to slect the date
		
		driver.findElement(By.xpath("//a[text()='22']")).click();
		
		String selectedDate = datePicker.getAttribute("value");
		
		// to print the selcted date 
		
		System.out.println("Selected Date: "+ selectedDate);
		
		driver.close();
		driver.quit();
		
	}

}
