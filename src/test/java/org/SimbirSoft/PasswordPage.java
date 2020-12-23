package org.SimbirSoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {

    public WebDriver webDriver;
    public PasswordPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
    }
    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/div[2]")
    private WebElement goPasswordButton;

    public void inputPasswd(String passwd) {
        passwordField.sendKeys(passwd); }

    public void clickPasswordnBtn() {
        goPasswordButton.click(); }
}
