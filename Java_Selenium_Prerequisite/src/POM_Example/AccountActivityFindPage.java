package POM_Example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountActivityFindPage {
	@FindBy(id="aa_fromDate")
	WebElement fromdate;
	
	@FindBy(id="aa_toDate")
	WebElement todate;
	
	@FindBy(xpath="//button[text()='Find']")
	WebElement find;
}
