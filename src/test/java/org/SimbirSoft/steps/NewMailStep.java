package org.SimbirSoft.steps;

import io.qameta.allure.Step;
import org.SimbirSoft.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewMailStep {

    private WebDriver webDriver;
    private ProfilePage profilePage;
    public String numberOfMails;

    public NewMailStep(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        profilePage = new ProfilePage(webDriver);
    }

    @Step("Создание нового письма")
    public String  createNewLetter() {
        numberOfMails = profilePage.countTheMails();
        profilePage.clickNewMailBtn();
        return numberOfMails;
    }
}
