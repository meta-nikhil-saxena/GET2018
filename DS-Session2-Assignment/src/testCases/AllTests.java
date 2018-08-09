package testCases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ QueueTest.class, TestInfixToPostfix.class,
        TestNestedList.class, TestPostfixEvaluation.class })
public class AllTests {

}
