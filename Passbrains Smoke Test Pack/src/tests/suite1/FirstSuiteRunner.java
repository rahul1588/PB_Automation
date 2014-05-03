package tests.suite1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
NoviceTester.class,
NoviceTester2Steps.class,
ProfessionalTester.class,
ProfTester3Steps.class


})

public class FirstSuiteRunner {

}
