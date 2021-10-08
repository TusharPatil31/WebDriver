package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		WebElement btn = driver.findElement(By.xpath("//button[@id='alertButton']"));
		btn.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement btn1 = driver.findElement(By.xpath("//button[@id='promtButton']"));
		btn1.click();
		
		Alert alert1 = driver.switchTo().alert();
		alert1.sendKeys("Clicked ok");
		alert1.accept();
		

	}

}
