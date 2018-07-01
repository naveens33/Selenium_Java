package selenium_webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assign_leave_page_scenario {

	static String driverPath="D:\\Selenium\\geckodriver-v0.21.0-win32\\";
	static public WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://opensource.demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
	
		WebDriverWait wait=new WebDriverWait(driver, 50);
		WebElement assignimg;
		assignimg= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1) > div > a")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", assignimg);
	 
		assignimg.click();
		
		//WebElement assignimg=driver.findElement(By.xpath("//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[1]/div/a/img"));
		//driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1) > div")).click();
		
	//	JavascriptExecutor js = (Javas	criptExecutor) driver;
	//	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", assignimg);
 
		
		driver.findElement(By.id("assignleave_txtEmployee_empName")).sendKeys("Linda Anderson");
		
		WebElement mySelectElement = driver.findElement(By.id("assignleave_txtLeaveType"));
		Select dropdown= new Select(mySelectElement);
		
		//dropdown.selectByVisibleText("Vacation US");
		dropdown.selectByIndex(3);

		driver.findElement(By.xpath("//*[@id='leaveBalance_details_link']")).click();
		
        String str=driver.findElement(By.xpath("//*[@id='balance_total']")).getText();
        if(str.equals("0.00"))
        {
        	System.out.println("Pass");
        }
        else
        {
        	System.out.println("Fail");
        }
        driver.findElement(By.id("closeButton")).click();
        //driver.close();
	}
}
