package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {

	
		public static void main (String[] args) throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.pinterest.com/");
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]/div[1]/header/div[1]/nav/div[2]/div[2]/button")).click();
			
			Thread.sleep(3000); 
			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("asmibajracharya9@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Asmi2004.");
			
			driver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]/div[1]/div[2]/div/div/div/div/div/div[3]/div[1]/div/div[1]/div[1]/form/div[7]/button/div")).click();
			Thread.sleep(5000);
			
			WebElement hover = driver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]/div[1]/div/div[3]/div/div/div/div/div/div[3]/div/div/div/div/div[1]/div/div/div/div/div[1]/a/div/div/div/div/div[1]/div/div/div/div/img"));
			
			Actions action = new Actions(driver);
			
			action.moveToElement(hover).perform();
			
			driver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]/div[1]/div/div[3]/div/div/div/div/div/div[3]/div/div/div/div/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div/div/div/button/div/div")).click();
			
			
			
			
			
			
			
			
	
	}

}
