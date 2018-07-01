package selenium_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Login_scenario {

	//static String driverPath="D:\\Selenium\\IEDriverServer_Win32_3.12.0\\";
	//static String driverPath="D:\\Selenium\\chromedriver_win32\\";
	static String driverPath="D:\\Selenium\\geckodriver-v0.21.0-win32\\";
	static public WebDriver driver;
	
	public static void main(String[] args) {
		// Launching browser
		//System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
		driver = new FirefoxDriver();
		
		// Maximize the browser
		driver.manage().window().maximize();
		
		// Navigate to the application 
		driver.navigate().to("http://opensource.demo.orangehrmlive.com/");
		
		//type the username and password
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		
		//click sign in button
		driver.findElement(By.id("btnLogin")).click();
		
		//close the browser and driver object
		driver.close();
	}

}
