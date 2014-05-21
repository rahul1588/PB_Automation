package tests.suite1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
NoviceTester.class,
NoviceTester2Steps.class,
Customer.class,
Customer_Tester.class,
ProfessionalTester.class,
ProfTester3Steps.class,
Customer_2steps.class,
Customer_Tester2steps.class

})

public class FirstSuiteRunner {

}
