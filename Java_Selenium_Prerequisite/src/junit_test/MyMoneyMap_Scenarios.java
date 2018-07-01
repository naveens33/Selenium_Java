package junit_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Inflow_Outflow_MyMoneyMap.class, Outflow_Chart_Verification.class })
public class MyMoneyMap_Scenarios {

}
