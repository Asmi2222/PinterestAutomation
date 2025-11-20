package test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup {
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pinterest.com/");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait for and click Sign up button
        WebElement signupButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//div[text()='Sign up']]")
            )
        );
        signupButton.click();
        
        // Wait for email field to be visible
        WebElement emailField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[type='email']")
            )
        );
        emailField.sendKeys("asmibajracharya9@gmail.com");
        
        // Wait for and fill password field
        WebElement passwordField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='password']")
            )
        );
        passwordField.sendKeys("Asmi2004.");
        
        // Wait for and fill birthdate field
        WebElement birthdateField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='birthdate']")
            )
        );
        birthdateField.sendKeys("01/09/2004");
        
        // Wait for and click Continue button
        WebElement continueButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='Continue']")
            )
        );
        continueButton.click();
    }
}