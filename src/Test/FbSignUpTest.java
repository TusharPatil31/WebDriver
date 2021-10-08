package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignUpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		WebElement CreateAccount = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		CreateAccount.click();
		
		WebElement UserName = driver.findElement(By.cssSelector("input[name=firstname]"));
		UserName.sendKeys("Patil");
		
		WebElement Day = driver.findElement(By.xpath("//select[@id='day']"));
		
		Select ddDay = new Select(Day);
		
//		ddDay.selectByVisibleText("14");
		ddDay.selectByValue("2");
//		ddDay.selectByIndex(6);
		
//		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
//		
//		Select Month = new Select(month);
//		
//		Month.selectByVisibleText("Feb");
		
		List<WebElement> Months = driver.findElements(By.xpath("//select[@id='month']/option"));
        
        for(int i=1;i<=Months.size();i++) {
            
            WebElement data = driver.findElement(By.xpath("//select[@id='month']/option[" + i + "]"));
            System.out.println(data.getText());
        }
		
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		
		Select Year = new Select(year);
		
		Year.selectByVisibleText("2020");
		
		WebElement male = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		male.click();
		
		if(male.isSelected())
		{
			System.out.println("Radio button is selected");
		}else
		{
			System.out.println("Radio is not selected");
		}
				

	}

}
