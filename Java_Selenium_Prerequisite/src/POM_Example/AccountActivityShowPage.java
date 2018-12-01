package POM_Example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountActivityShowPage {
	@FindBy(xpath="//a[text()='Find Transactions']")
	WebElement findtransactions;
}
