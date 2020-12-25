package org.SimbirSoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@gh=\"cm\"]")
    private WebElement newMailBtn;

    public String countTheMails() {
        List<WebElement> mails = driver.findElements(By.xpath("//*[@name =\"farit.valiahmetov\"]"));
        return Integer.toString(mails.size()/2);
    }

    public void clickNewMailBtn() {
        newMailBtn.click();
    }
}