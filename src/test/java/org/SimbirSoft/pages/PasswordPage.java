package org.SimbirSoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {

    private WebDriver webDriver;

    public PasswordPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@type=\"button\"]")
    private WebElement goPasswordButton;

    public void inputPasswd(String passwd) {
        passwordField.sendKeys(passwd);
    }

    public void clickPasswordBtn() {
        goPasswordButton.click();
    }
}