package Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver","chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.tutorialspoint.com/about/about_careers.htm");	
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		WebElement Link = driver.findElement(By.linkText("Terms of Use"));
		
		String keystosend = Keys.chord(Keys.CONTROL,Keys.ENTER);
		
		Link.sendKeys(keystosend);
		
		ArrayList<String> allwindows = new ArrayList<String> (driver.getWindowHandles());
		
		for(String window: allwindows)
		{
			System.out.println(window);
			
		}
		
		driver.switchTo().window(allwindows.get(1));
		
		WebElement element = driver.findElement(By.tagName("h1"));
		
		System.out.println(element.getText());
		
//		driver.close();
		
		driver.quit();

	}

}
