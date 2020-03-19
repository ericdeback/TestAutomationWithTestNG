package FunctionalTests.BT;

import Main.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import static org.testng.Assert.*;

@Ignore
public class BasicBTValidations extends Shared {
    private final String baseURL = "http://www.bt.com";

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(Main.Enums.Browser browser) {

        setExecutionContext(browser);
        driver.get(baseURL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div/div/button[2]")));
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/button[2]")).click();

        // not a test, just checking
        assertEquals(driver.getTitle(), "Fibre Broadband, TV Packages, BT Sport & Mobile Deals | BT");
    }

    @Test
    void TestCase201(){


        // click BT email
        driver.get("https://signin1.bt.com/login/emailloginform");

        // wait for "SignIn" to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div/div[7]/form/h1")));

        // key in user name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputIdEmail")));
        driver.findElement(By.id("inputIdEmail")).sendKeys("eric.deback@btinternet.com");

        // key in password
        driver.findElement(By.id("nafmpwd")).sendKeys("1lovewilliam");

        // click sign in
        driver.findElement(By.id("btsignin")).click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div/div/div[2]/div/div[3]/div[3]/a/span[2]")));

        String currentTitle = driver.getTitle();
        assertTrue(currentTitle.length()>0);

        String expectedTitle = "- eric.deback@btinternet.com - BT Yahoo Mail";
        assertEquals(currentTitle.substring(currentTitle.length()-expectedTitle.length()), expectedTitle);
    }

    @AfterClass
    public void cleanup() {
        System.out.println("Do this after test");

        driver.quit();
    }
}
