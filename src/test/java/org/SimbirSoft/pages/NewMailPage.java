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

    @FindBy(name = "to")
    private WebElement recipient;

    @FindBy(name = "subjectbox")
    private WebElement theme;

    @FindBy(xpath = "//*[@role=\"textbox\"]")
    private WebElement message;

    @FindBy(className = "T-I J-J5-Ji aoO v7 T-I-atl L3")
    private WebElement sendBtn;

    @FindBy(className = "Hq aUG")
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