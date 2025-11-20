package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pinterest.com/");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Click login button
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//div[text()='Log in']]")
            ));
            loginBtn.click();

            // Wait for login form to appear and fill credentials
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")))
                .sendKeys("asmibajracharya9@gmail.com");
            
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            passwordField.sendKeys("Asmi2004.");

            // Click login button in popup
            WebElement popupLoginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='dialog']//button[.//div[text()='Log in']]")
            ));
            js.executeScript("arguments[0].click();", popupLoginButton);
            
            System.out.println("Login successful, waiting for posts...");

            // Wait for first post to appear (using longer wait as page loads)
            WebElement firstPost = longWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[data-test-id='pin']")
            ));
            System.out.println("First post found");

            // Scroll post into view
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", firstPost);
            
            // Wait for scroll to complete by checking if element is stable
            wait.until(ExpectedConditions.visibilityOf(firstPost));

            // Hover over post
            actions.moveToElement(firstPost).perform();
            System.out.println("Hovering over post...");
            
            // Wait for hover actions to trigger (wait for save button to appear)
            WebElement saveButton = null;
            
            // Strategy 1: Find within the post element
            try {
                saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(".//div[contains(@class, 'lIkAnG') and text()='Save']")
                ));
                System.out.println("Save button found using class strategy");
            } catch (Exception e) {
                System.out.println("Strategy 1 failed, trying strategy 2...");
            }

            // Strategy 2: Find visible save button anywhere
            if (saveButton == null) {
                try {
                    saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[text()='Save' and contains(@class, 'lIkAnG')]")
                    ));
                    System.out.println("Save button found using visible element strategy");
                } catch (Exception e) {
                    System.out.println("Strategy 2 failed, trying strategy 3...");
                }
            }

            // Strategy 3: Find button containing Save text
            if (saveButton == null) {
                saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[.//div[text()='Save']]")
                ));
                System.out.println("Save button found using button strategy");
            }

            // Click save button
            try {
                wait.until(ExpectedConditions.elementToBeClickable(saveButton));
                saveButton.click();
                System.out.println("Save button clicked successfully");
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", saveButton);
                System.out.println("Save button clicked using JavaScript");
            }

            // Wait for save action to complete - board modal or saved confirmation
            System.out.println("Waiting for save action to complete...");
            try {
                // Check if board selection modal appears
                wait.until(ExpectedConditions.or(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']//h1")),
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'BoardPickerOverlay')]"))
                ));
                System.out.println("Board selection modal appeared");
                
                // Wait for and click first available board
                WebElement firstBoard = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='dialog']//div[@role='button'][1]")
                ));
                js.executeScript("arguments[0].click();", firstBoard);
                System.out.println("Board selected");
                
                // Wait for modal to close using locator
                wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//div[@role='dialog']//h1")
                ));
                System.out.println("Modal closed");
            } catch (Exception e) {
                System.out.println("No board modal appeared - pin saved directly");
            }

            // Navigate to profile
            System.out.println("Navigating to profile...");
            WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@title='Profile' and contains(@class, 'WuRgKB')]")
            ));
            js.executeScript("arguments[0].click();", profileButton);
            System.out.println("Profile button clicked");

            // Wait for profile page to load
            wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("/pins/"),
                ExpectedConditions.urlContains("/_saved/")
            ));

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("/pins/") || currentUrl.contains("/_saved/")) {
                System.out.println("Successfully navigated to profile/saved pins!");
            }

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Wait briefly to see final state before closing
            try {
                wait.until(d -> true); // Small pause for observation
            } catch (Exception ignored) {}
            driver.quit();
        }
    }
}