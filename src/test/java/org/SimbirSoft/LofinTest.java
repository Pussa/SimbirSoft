package org.SimbirSoft;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.apache.maven.Maven;
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

    public static LoginPage loginpage;
    public static PasswordPage passwordpage;
    public static profilePage profilepage;
    public static NewMailPage newmailpage;
    public static WebDriver webDriver;
    public String numberOfMails;


    @BeforeClass
    public static void setup() throws NullPointerException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/strel/IdeaProjects/SimbirSoft/src/test/resources/chromedriver.exe");
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        loginpage = new LoginPage(webDriver);
        passwordpage = new PasswordPage(webDriver);
        profilepage = new profilePage(webDriver);
        newmailpage = new NewMailPage(webDriver);
        webDriver.get("https://gmail.com");
    }

    @Test
    public void Test() throws InterruptedException {

        LoginTest();
        NewMailTest();
        MailTest();

    }


    @Step("Вход в аккаунт")
    public void LoginTest() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginpage.inputLogin("lkek58153@gmail.com");

        loginpage.clickLoginBtn();

        passwordpage.inputPasswd("gfl2dasa");
        passwordpage.clickPasswordnBtn();
    }


    @Step("Создание нового письма")
    public void NewMailTest(){
        numberOfMails=profilepage.countTheMails();
        profilepage.clickNewMailBtn();}


    @Step("Заполнение полей письма")
    public void MailTest() throws InterruptedException {
        newmailpage.clickbbBtn();
        Thread.sleep(2000);

        newmailpage.inputRecipient("farit.valiahmetov@simbirsoft.com");
        Thread.sleep(2000);

        newmailpage.inputTheme("Тестовое задание. Цаценко");
        Thread.sleep(2000);

        newmailpage.inputMessage("Найденное количество писем: "+numberOfMails);
        Thread.sleep(2000);

        newmailpage.clickSendBtn();
        Thread.sleep(3000);


    }
    @AfterClass
    public static void tearDown() {
        webDriver.quit();

    }
}

