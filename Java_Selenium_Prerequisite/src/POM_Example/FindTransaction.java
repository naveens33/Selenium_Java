package POM_Example;

import org.testng.annotations.Test;

import mymoneymap.Repository;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class FindTransaction {
	static WebDriver driver;

  @BeforeClass
  public void beforeClass() {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Training\\Batch3\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/");
		WebElement signin1=driver.findElement(By.xpath("//button[@id='signin_button']"));
		signin1.click();
		
		
		LoginPage loginpage=new LoginPage();
		PageFactory.initElements(driver, loginpage);
		
		loginpage.username.sendKeys("username");
		loginpage.password.sendKeys("password");
		loginpage.signin.click();
		
		AccountSummaryPage accountsummarypage=new AccountSummaryPage();
		PageFactory.initElements(driver, accountsummarypage);
		accountsummarypage.accountactivity.click();
		
		AccountActivityShowPage accountactivityshowpage=new AccountActivityShowPage();
		PageFactory.initElements(driver, accountactivityshowpage);
		accountactivityshowpage.findtransactions.click();

		
  }
  
  @Test
  public void findByDate() {
		
	  	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
		AccountActivityFindPage accountactivityfindpage= new AccountActivityFindPage();
		PageFactory.initElements(driver, accountactivityfindpage);
		
		accountactivityfindpage.fromdate.sendKeys("2012-01-01");
		accountactivityfindpage.todate.sendKeys("2012-12-31");
		accountactivityfindpage.find.click();
		
		
		
  }
  
  @AfterClass
  public void afterClass() {
  }

}
