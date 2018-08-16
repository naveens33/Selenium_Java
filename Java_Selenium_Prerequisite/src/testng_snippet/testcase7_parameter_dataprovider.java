package testng_snippet;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testcase7_parameter_dataprovider {
	@Test(dataProvider = "Inflow")
	public void test(String attribute, String value) {
		System.out.println("Attribute: "+attribute+", Value: "+value);
	}

	@DataProvider(name = "Inflow")
	public Object[][] provideData() {

		return new Object[][] { 
			{ "Direct Deposits", "$0.00" }, 
			{ "Other Deposits", "$5,000.00" }, 
			{ "Transfers from other Zero Bank Accounts", "$1,150.00" } 
		};
	}
}
