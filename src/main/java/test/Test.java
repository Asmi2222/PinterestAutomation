package test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Test {
	public static void main (String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.pinterest.com/");
		
		// Wait for and click Explore button
		WebElement exploreButton = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//span[text()='Explore']")
		));
		exploreButton.click();
		
		// Wait for URL to contain 'ideas'
		wait.until(ExpectedConditions.urlContains("ideas"));
		
		// Wait for search box and enter search query
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.cssSelector("input[data-test-id='search-box-input']")
		));
		searchBox.sendKeys("easy food recipes" + Keys.ENTER);
		
		
	}
}