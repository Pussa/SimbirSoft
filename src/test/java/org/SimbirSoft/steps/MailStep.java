package org.SimbirSoft.steps;

import io.qameta.allure.Step;
import org.SimbirSoft.pages.NewMailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailStep {

    private WebDriver webDriver;
    private NewMailPage newMailPage;
    private WebDriverWait wait;

    public MailStep(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
        newMailPage = new NewMailPage(webDriver);
    }

    @Step("Заполнение полей письма и его отправка")
    public void fillingSectionsOfLetter(String numberOfMails, String emailOfRecipient) {
        newMailPage.clickbsBtn();
        newMailPage.inputRecipient(emailOfRecipient);
        newMailPage.inputTheme("Simbirsoft theme");
        newMailPage.inputMessage("Найденное количество писем: " + numberOfMails);
        newMailPage.clickSendBtn();
        wait.until(ExpectedConditions.textToBe(By.className("bAq"), "Письмо отправлено."));
    }
}
