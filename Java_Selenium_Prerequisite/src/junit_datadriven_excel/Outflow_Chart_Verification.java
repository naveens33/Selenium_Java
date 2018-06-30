package junit_datadriven_excel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Outflow_Chart_Verification {

	static String driverPath="D:\\Selenium Training\\chromedriver_win32(1)\\";
	static public WebDriver driver;

	@BeforeClass
	static public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Before
	public void login()
	{
		driver.navigate().to("http://zero.webappsecurity.com/index.html");
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
	}

	@After
	public void logout()
	{
		driver.findElement(By.xpath("//*[@id='settingsBox']/ul/li[3]/a")).click();
		driver.findElement(By.id("logout_link")).click();
	}
	
	@AfterClass
	static public void closebrowser()
	{
		driver.close();
	}
	
	@Ignore
	@Test
	public void unselect_category() {
		List<String> attribute = new ArrayList();
		attribute.add("Transportation");
		attribute.add("Auto");
		attribute.add("Charity");
		
		driver.findElement(By.cssSelector("li#money_map_tab>a")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Charity'][1]")));
		for(int i=0;i<attribute.size();i++)
		{
			driver.findElement(By.xpath("//*[@text='"+attribute.get(i)+"'][2]")).click();
			Assert.assertEquals(false, driver.findElement(By.xpath("//*[@text='"+attribute.get(i)+"'][1]")).isDisplayed());
		}
	}

	@Ignore
	@Test
	public void select_category() {
		List<String> attribute = new ArrayList();
		attribute.add("Transportation");
		attribute.add("Auto");
		attribute.add("Charity");
		
		driver.findElement(By.cssSelector("li#money_map_tab>a")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Charity'][1]")));
		for(int i=0;i<attribute.size();i++)
		{
			driver.findElement(By.xpath("//*[@text='"+attribute.get(i)+"'][2]")).click();
		}
		for(int i=0;i<attribute.size();i++)
		{
			driver.findElement(By.xpath("//*[@text='"+attribute.get(i)+"'][2]")).click();
			Assert.assertEquals(true, driver.findElement(By.xpath("//*[@text='"+attribute.get(i)+"'][1]")).isDisplayed());
		}
	}
}
