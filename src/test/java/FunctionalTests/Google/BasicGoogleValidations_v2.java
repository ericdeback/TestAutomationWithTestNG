package FunctionalTests.Google;

import Main.*;
import com.sun.org.glassfish.gmbal.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.io.*;

import static TOM.HomePage.*;
import static org.testng.Assert.*;

// 1. handle unexpected assert fails:
// capture screen shot when test fails and log info for bug report
// 2. better reporting MI
// 3. run tests on different browsers

//@Ignore
public class BasicGoogleValidations_v2 extends Shared {
    private final String baseURL = "http://www.google.co.uk";

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(Main.Enums.Browser browser) {

        setExecutionContext(browser);
        driver.get(baseURL);

        // not a test, just checking
        assertEquals("Google", driver.getTitle());
    }

    @Test(dataProvider = "generateIntegerData")
    /*
        Test case 101:
            Validates the use of a DataProvider of ints
    */
    @Description("Validates the use of a DataProvider of ints")
    void TestCase101(int input, int expectedResult){

        assertEquals(input, expectedResult);

    }

    @Test(dataProvider = "generateMixedeData") //, dependsOnMethods = { "TestCase101" })
    /*
        Test case 102:
            Validates the use of a DataProvider of ints & Strings
    */
    @Description("Validates the use of a DataProvider of ints & Strings")
    void TestCase102(Integer input, String expectedResult){
        assertEquals(input, Integer.valueOf(expectedResult));
    }

    @Test
    /*
        Test case 103:
            Validates Google homepage and use of the TOM, uses static method imports
    */
    @Description("alidates Google homepage and use of the TOM, uses static method imports")
    void TestCase103() {

        // test the size of the Google logo
        WebElement we  = driver.findElement(By.id(getGoogleLogoIdLocator())); // get the locator from the TOM
        assertEquals(we.getSize(), new Dimension(272, 201)); // dimension will change depending on local screen
    }

    @Test
    /*
    Validates the capture of cookies from the server response. Clumsily stores in file for re-use
    */
    @Description("Validates the capture of cookies from the server response. Clumsily stores in file for re-use")
    void cookieTest(){

        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");

        // Input Email id and Password If you are already Register
        driver.findElement(By.name("username")).sendKeys("abc123");
        driver.findElement(By.name("password")).sendKeys("123xyz");
        driver.findElement(By.name("submit")).click();

        // create file named Cookies to store Login Information
        File file = new File("c:\\data\\Cookies.data");
        try
        {
            // Delete old file if exists
            file.delete();
            file.createNewFile();

            BufferedWriter Bwrite = new BufferedWriter(new FileWriter(file));
            // loop for getting the cookie information

            // loop for getting the cookie information
            for(Cookie ck : driver.manage().getCookies())
            {
                Bwrite.write(("Name: "+ck.getName()+"="+ck.getValue()+"; Domain="+ck.getDomain()+"; Path="+ck.getPath()+"; Expiry="+ck.getExpiry()+"; IsSecure="+ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();

            driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @AfterClass
    public void cleanup() {
        System.out.println("Do this after test");

        driver.close();
        driver.quit();
    }



}

