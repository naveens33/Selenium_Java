package junit_datadriven_excel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Inflow_Outflow_Scenario.class, Outflow_Chart_Verification.class})
public class MyMoneyMapScenarios {

}
