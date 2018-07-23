/**
 *  Test suite which test all the Test classes covered in it
 *  
 *  MaxMirrorLengthTest
 *  ClumpsInArrayTest
 *  Fix_XY_Test
 *  SplitArrayTest
 */

package TestCasesArrOperation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClumpsInArrayTest.class, Fix_XY_Test.class,
        MaxMirrorLengthTest.class, SplitArrayTest.class })
public class AllTestsArrOperation {

}
