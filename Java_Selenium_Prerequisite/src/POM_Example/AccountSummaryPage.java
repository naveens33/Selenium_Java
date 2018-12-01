package POM_Example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummaryPage {
	@FindBy(xpath="//a[text()='Account Activity']")
	WebElement accountactivity;
}
