package selenium_webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Add_new_payee {

	static String driverPath="D:\\Selenium\\chromedriver_win32\\";
	static public WebDriver driver;

	static void login()
	{
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://zero.webappsecurity.com/index.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
	}
	
	static void AddNewPayee()
	{
		driver.findElement(By.xpath("//li[@id='pay_bills_tab']/a")).click();
		driver.findElement(By.xpath("//div[@id='tabs']/ul/li[2]/a")).click();
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Franch Express");
		driver.findElement(By.cssSelector("textarea.span4[name='address']")).sendKeys("Denmark");
		driver.findElement(By.cssSelector("input.span4[name='account']")).sendKeys("23564589756");
		driver.findElement(By.cssSelector("input.span4[name='details']")).sendKeys("Business");
		driver.findElement(By.cssSelector("div.pull-right>input#add_new_payee")).click();
		
		String alert=driver.findElement(By.id("alert_content")).getText();
		if(alert.equals("The new payee Franch Express was successfully created."))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		WebElement mySelectElement = driver.findElement(By.id("sp_payee"));
		mySelectElement.click();
		Select dropdown= new Select(mySelectElement);
		
		//dropdown.selectByVisibleText("Vacation US");
		List<WebElement> options=dropdown.getOptions();
		int count=0;
		for(WebElement element:options)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		 
			if(element.getText().equals("Franch Express"))
			{
				count++;
				break;
			}
		}
		if(count==0){System.out.println("Fail");}
	}
	public static void main(String[] args) {
		login();
		AddNewPayee();
	}

}
