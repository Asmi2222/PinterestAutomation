package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	public static void main (String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pinterest.com/");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]/div[1]/header/div[1]/nav/div[2]/div[3]/button")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("asmibajracharya9@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Asmi2004.");
		driver.findElement(By.xpath("//*[@id=\"birthdate\"]")).sendKeys("01/09/2004");
//		driver.findElement(By.("")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div[1]/button/div")).click();
		driver.findElement(By.xpath("//*[@id=\"combobox-combo-box-language\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div[1]/div[3]/div/div[2]/div/button/div/div")).click();
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div/div[3]/div/div/div[2]/div/div[1]/div/div/div[1]/div/div/div/div[1]/div/div/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div/div[3]/div/div/div[2]/div/div[1]/div/div/div[9]/div/div/div/div[1]/div/div/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div/div[3]/div/div/div[3]/div/button/div")).click();
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div/div[3]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div/div/div/div/div/div/div/div/div/div/div/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div/div[3]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div/div[3]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div/div[3]/div/div/div[3]/div")).click();
		Thread.sleep(3000);
		
		

		
		
		
		
		
		

		
		
	}

}
