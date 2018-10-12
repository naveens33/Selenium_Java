package samplecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class tooltip_verification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Training\\Batch3\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/");
		
		WebElement signin1=driver.findElement(By.id("signin_button"));
		signin1.click();
		
		WebElement que=driver.findElement(By.id("credentials"));
		Actions action=new Actions(driver);
		action.moveToElement(que).build().perform();
		
		if(driver.findElement(By.xpath("//*[@id='login_form']/div[1]/div[1]/div/div/div[2]")).getText().equals("Login/Password - username/password"))
		{
			
		}
	}

}
