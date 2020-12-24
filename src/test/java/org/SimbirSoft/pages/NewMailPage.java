package org.SimbirSoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMailPage {

    public WebDriver driver;

    public NewMailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@aria-label=\"Кому\"]")
    private WebElement recipient;

    @FindBy(xpath = "//*[@aria-label=\"Тема\"]")
    private WebElement theme;

    @FindBy(xpath = "//*[@class=\"Am Al editable LW-avf tS-tW\"]")
    private WebElement message;

    @FindBy(xpath = "//*[@class = \"T-I J-J5-Ji aoO v7 T-I-atl L3\"]")
    private WebElement sendBtn;

    @FindBy(xpath = "//*[@aria-label =\"Во весь экран (Shift для всплывающего окна)\"]")
    private WebElement bsBtn;

    public void clickSendBtn() {
        sendBtn.click();
    }

    public void clickbsBtn() {
        bsBtn.click();
    }

    public void inputRecipient(String recipient) {
        this.recipient.sendKeys(recipient);
    }

    public void inputTheme(String theme) {
        this.theme.sendKeys(theme);
    }

    public void inputMessage(String message) {
        this.message.sendKeys(message);
    }
}