package org.SimbirSoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(name = "identifier")
    private WebElement loginField;
    @FindBy(xpath = "//*[@type=\"button\"]")
    private WebElement goLoginButton;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void clickLoginBtn() {
        goLoginButton.click();
    }
}