package org.SimbirSoft.pages;

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

    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/div[2]")
    private WebElement goLoginButton;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void clickLoginBtn() {
        goLoginButton.click();
    }
}