package org.SimbirSoft.steps;

import io.qameta.allure.Step;
import org.SimbirSoft.pages.LoginPage;
import org.SimbirSoft.pages.PasswordPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginStep {

    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private WebDriver webDriver;

    public LoginStep(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        loginPage = new LoginPage(webDriver);
        passwordPage = new PasswordPage(webDriver);
    }

    @Step("Вход в аккаунт")
    public void test(String email, String password) {
        loginPage.inputLogin(email);
        loginPage.clickLoginBtn();
        passwordPage.inputPasswd(password);
        passwordPage.clickPasswordBtn();
    }
}
