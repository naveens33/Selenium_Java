package testng_demo_class;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class OnlineBanking {
	static String driverPath="D:\\Selenium Training\\chromedriver_win32(1)\\";
	static public WebDriver driver;
	List<String> links=new ArrayList();
	
	@BeforeSuite
	  public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("BeforeSuite");
	  }

	@BeforeClass
	public void initialize()
	{ 
		  links.add("Account Summary");
		  links.add("Account Activity");
		  links.add("Transfer Funds");
		  links.add("Pay Bills");
		  links.add("My Money Map");
		  links.add("Online Statements");
		  System.out.println("BeforeClass");
	}
	@BeforeMethod
	  public void navigateto() {
		  driver.navigate().to("http://zero.webappsecurity.com/index.html");
	    System.out.println("BeforeMethod");
	  }


	  
	  @Ignore
	  @Test (priority=1)
	  public void withoutsignin() {
		  driver.findElement(By.xpath("//strong[contains(text(),'Online Banking')]")).click();
		  
		  for(String str:links)
		  {
			  driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]")).click();
			  Assert.assertEquals(driver.getTitle(),"Zero - Log in");
			  driver.navigate().back();
		  }
		  
		  driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		  Assert.assertEquals(driver.getTitle(),"Zero - Log in");
		  System.out.println("withoutsignin");
		  }	  
	  
	  @Test (priority=2)
	  public void withsignin() {
			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.name("user_password")).sendKeys("password");
			driver.findElement(By.name("submit")).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'Zero Bank')]")).click();
			driver.findElement(By.xpath("//strong[contains(text(),'Online Banking')]")).click();
			
			 for(String str:links)
			  {
				  driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]")).click();
				  Assert.assertEquals(driver.getTitle(), "Zero - "+str);
				  driver.navigate().back();
			  }
			
			driver.findElement(By.xpath("//*[@id='settingsBox']/ul/li[3]/a")).click();
			driver.findElement(By.id("logout_link")).click();
			    System.out.println("withsignin");
			  }
}
