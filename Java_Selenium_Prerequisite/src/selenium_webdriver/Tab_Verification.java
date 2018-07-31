package selenium_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tab_Verification {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Training\\Batch2\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://zero.webappsecurity.com/");
		
		login("username","password");
	}
	private static void login(String uname, String pword) {
		WebElement signin=driver.findElement(By.id("signin_button"));
		signin.click();
		
		driver.findElement(By.id("user_login")).sendKeys(uname);
		
		driver.findElement(By.id("user_password")).sendKeys(pword);
		
		driver.findElement(By.name("submit")).click();
		
		assertfun(driver.getTitle(),"Zero - Account Summary");
		
	}
	
	private static void assertfun(String actualtitle, String expectedtitle) {

		if(actualtitle.equals(expectedtitle))
		{
			System.out.println("Pass");
		}
		else
		{
			driver.close();
			try {
				throw new MyException(); 	
			} catch (MyException e) {
				 System.out.println(e);
			}
		}
	}

}
