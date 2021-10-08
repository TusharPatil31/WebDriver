package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		
//		System.setProperty("webdriver.gecko.driver","geckodriver");
//		
//		WebDriver driver  = new FirefoxDriver	();
//		
//		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(LoginLink));
			
		LoginLink.click();
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abcd@123");
		
		WebElement Remember = driver.findElement(By.className("rememberMe"));
		Remember.click();
		
		WebElement LoginButton = driver.findElement(By.name("btn_login"));
		LoginButton.click();
		
		WebElement Error = driver.findElement(By.id("msg_box"));
		
		String Actualmsg = Error.getText();
		String Expmsg = "The email or password you have entered is invalid.";
		
		if(Actualmsg.equals(Expmsg))
		{
			System.out.println("Test Passed");
		}else
		{
			System.out.println("Test Failed");
		}
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links are:" + Links.size());
		
		for(WebElement data : Links)
		{
			System.out.println(data.getText());
			System.out.println("Target URL is :" +data.getAttribute("href"));
		}

		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		
		
//		WebElement ForgotPass = driver.findElement(By.partialLinkText("Forgot"));
//		ForgotPass.click();
		
//		Thread.sleep(5000);
//		
//		driver.quit();
		
	}

}
