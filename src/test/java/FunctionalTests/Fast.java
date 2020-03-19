package FunctionalTests;

import Main.*;
import com.sun.org.glassfish.gmbal.*;
import org.testng.annotations.*;

import static org.testng.Assert.*;

// 1. handle unexpected assert fails:
// capture screen shot when test fails and log info for bug report
// 2. better reporting MI
// 3. run tests on different browsers

//@Ignore
public class Fast extends Shared {
    private final String baseURL = "http://www.google.co.uk";

    @BeforeClass
    public void setUp() {
    }

    @Test(dataProvider = "generateIntegerData")
    /*
        Test case 101: Validates the use of a DataProvider of ints
    */
    @Description("Validates the use of a DataProvider of ints")
    void TestCase101(int input, int expectedResult){

        assertEquals(input, expectedResult);
    }

    @Test(dataProvider = "generateMixedeData") //, dependsOnMethods = { "TestCase101" })
    /*
        Test case 102: Validates the use of a DataProvider of ints & Strings
    */
    @Description("Validates the use of a DataProvider of ints & Strings")
    void TestCase102(Integer input, String expectedResult){
        assertEquals(input, Integer.valueOf(expectedResult));
    }


    @Test(dependsOnMethods = { "TestCase102" })
    @Description("Dummy test case")
    void TestCase103(Integer input, String expectedResult){
        assertEquals(input, Integer.valueOf(expectedResult));
    }


    @AfterClass
    public void cleanup() {
        System.out.println("Do this after test");

    }
}

