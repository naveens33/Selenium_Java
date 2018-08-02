package selenium_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Scenario_2 {

	static WebDriver driver;
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.ie.driver", "D:\\Selenium Training\\Batch2\\IEDriverServer_Win32_3.13.0\\IEDriverServer.exe");
		//driver=new InternetExplorerDriver();
		
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium Training\\Batch2\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		//driver=new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Training\\Batch2\\geckodriver-v0.21.0-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("http://zero.webappsecurity.com/");
		
		WebElement signin=driver.findElement(By.id("signin_button"));
		signin.click();
		
		driver.findElement(By.id("user_login")).sendKeys("username");
		
		driver.findElement(By.id("user_password")).sendKeys("pass");
		
		driver.findElement(By.name("submit")).click();
		
		if(driver.getTitle().equals("Zero - Log in"))
		{
			System.out.println("Pass: Title is correct");
		}
		else
		{
			System.err.println("Fail: Title is incorrect");
		}
		
		if(driver.findElement(By.xpath("//*[@id='login_form']/div[1]")).getText().equals("Login and/or password are wrong."))
		{
			System.out.println("Pass: Error message displayed");
		}
		else
		{
			System.err.println("Fail: Error message not displayed");
		}
		
			
		driver.close();
	}

}
