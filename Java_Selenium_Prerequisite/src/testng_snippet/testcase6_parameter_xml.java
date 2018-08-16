package testng_snippet;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testcase6_parameter_xml {
  @Test
  @Parameters({ "username", "password" })
  public void test(String username, String password) {
	  System.out.println("Parameter: "+username +", "+password);
  }
}
