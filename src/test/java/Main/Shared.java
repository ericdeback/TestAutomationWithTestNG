package Main;

import Main.Enums.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class Shared {
    public WebDriver driver = null;
    public WebDriverWait wait;

    public void setExecutionContext(Browser browser){

        switch(browser) {
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
                driver = new ChromeDriver();
                wait = new WebDriverWait(driver,30);
                break;
            case IE:
            case Firefox:
        }

    }

    @DataProvider(name="generateIntegerData")
    public Object[][] foo1() {
        Object[][] data = new Object[3][2];

        data[0][0] = 7;
        data[0][1] = 7;

        data[1][0] = 5;
        data[1][1] = 5;

        data[2][0] = 5;
        data[2][1] = 6;

        return data;
    }

    @DataProvider(name="generateMixedeData")
    public Object[][] foo2() {
        Object[][] data = new Object[3][2];

        data[0][0] = 7;
        data[0][1] = "7";

        data[1][0] = 3;
        data[1][1] = "3";

        data[2][0] = 5;
        data[2][1] = "6";

        return data;
    }
}
