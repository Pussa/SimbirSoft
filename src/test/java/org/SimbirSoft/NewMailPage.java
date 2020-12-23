package org.SimbirSoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMailPage {

    public WebDriver driver;
    public NewMailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@aria-label=\"Кому\"]")
    private WebElement Recipient;

    @FindBy(xpath = "//*[@aria-label=\"Тема\"]")
    private WebElement Theme;

    @FindBy(xpath = "//*[@class=\"Am Al editable LW-avf tS-tW\"]")
    private WebElement Message;

    @FindBy(xpath = "//*[@class = \"T-I J-J5-Ji aoO v7 T-I-atl L3\"]")
    private WebElement SendBtn;

    @FindBy(xpath = "//*[@aria-label =\"Во весь экран (Shift для всплывающего окна)\"]")
    private WebElement bbBtn;

    public void clickSendBtn() {
        SendBtn.click(); }
    public void clickbbBtn() {
        bbBtn.click(); }

    public void inputRecipient(String recipient) {
        Recipient.sendKeys(recipient); }

    public void inputTheme(String theme) {
        Theme.sendKeys(theme); }

    public void inputMessage(String msg) {
        Message.sendKeys(msg); }


}
