package automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateSignUpAndLoginFunctionality {

    public static void main(String[] args) {
        
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        
        // Navigate to GUVI login page
        driver.get("https://www.guvi.in/");
        
        // Wait for the driver to load and maximize the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        // Login to GUVI
        driver.findElement(By.id("login-btn")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("kaviya20venkat@gmail.com");
        driver.findElement(By.id("password")).sendKeys("VJkavi@1420");
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        
        // Verify successful login with an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gravatar")));
            System.out.println("Login successful");
        } catch (Exception e) {
            System.out.println("Login not successful");
        }
        
        // Logout
        driver.findElement(By.className("gravatar-wrap")).click();
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();
        
        // Start Sign-up process
        driver.findElement(By.xpath("//a[text()='Sign up']")).click();
        
        driver.findElement(By.id("name")).sendKeys("Kaviya");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("vijay95venkat@gmail.com");
        driver.findElement(By.id("password")).sendKeys("VJkavi@1420");
        driver.findElement(By.cssSelector("input#mobileNumber")).sendKeys("6382050742");
        
        WebElement signUp = driver.findElement(By.id("signup-btn"));
        signUp.click();
        
        // Verify successful sign-up with explicit wait
        try {
            WebElement profileIcon2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gravatar")));
            System.out.println("The user signed up successfully");
        } catch (Exception e) {
            System.out.println("The user did not sign up successfully");
        }
        
        // Close the browser
        driver.quit();
    }
}
