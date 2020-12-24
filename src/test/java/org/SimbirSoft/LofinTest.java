package org.SimbirSoft;

import org.SimbirSoft.steps.LoginStep;
import org.SimbirSoft.steps.MailStep;
import org.SimbirSoft.steps.NewMailStep;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LofinTest {

    private static LoginStep loginStep;
    private static NewMailStep newMailStep;
    private static MailStep mailStep;
    private static WebDriver webDriver;
    private String email;
    private String password;
    private String emailOfRecipient;

    @BeforeClass
    public static void setup() throws NullPointerException {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginStep = new LoginStep(webDriver);
        newMailStep = new NewMailStep(webDriver);
        mailStep = new MailStep(webDriver);
        webDriver.get("https://gmail.com");
    }

    @Test
    public void test() {
        email = "lkek58153@gmail.com";
        password = "gfl2dasa";
        emailOfRecipient = "farit.valiahmetov@simbirsoft.com";
        loginStep.test(email, password);
        mailStep.test(newMailStep.test(), emailOfRecipient);
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }
}

