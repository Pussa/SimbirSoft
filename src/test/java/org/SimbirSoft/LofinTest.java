package org.SimbirSoft;

import org.SimbirSoft.steps.LoginStep;
import org.SimbirSoft.steps.MailStep;
import org.SimbirSoft.steps.NewMailStep;

import org.aeonbits.owner.ConfigFactory;
import org.apache.struts.config.impl.DefaultModuleConfigFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LofinTest {

    private static LoginStep loginStep;
    private static NewMailStep newMailStep;
    private static MailStep mailStep;
    private static WebDriver webDriver;
    private static Cfg cfg;

    @BeforeClass
    public static void setup() throws NullPointerException {
        cfg= ConfigFactory.create(Cfg.class);
        System.setProperty(cfg.chromeDriver(), cfg.wayToDriver());
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(cfg.waiting(), TimeUnit.SECONDS);
        loginStep = new LoginStep(webDriver);
        newMailStep = new NewMailStep(webDriver);
        mailStep = new MailStep(webDriver);
        webDriver.get(cfg.website());
    }

    @Test
    public void test() {
        loginStep.accountLogin(cfg.email(), cfg.password());
        mailStep.fillingSectionsOfLetter(newMailStep.createNewLetter(), cfg.emailOfRecipient());
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }
}

//Selenium Grid
  /*  try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
