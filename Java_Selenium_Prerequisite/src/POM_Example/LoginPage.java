package POM_Example;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage {

	@FindBy(xpath="//*[@id='user_login']")
	WebElement username;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(name="submit")
	WebElement signin;
	
}
