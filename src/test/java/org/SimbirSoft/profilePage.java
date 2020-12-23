package org.SimbirSoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.SimbirSoft.LofinTest.webDriver;

public class profilePage {

    public WebDriver driver;
    public profilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    @FindBy(xpath = "//*[@gh=\"cm\"]")
    private WebElement NewMailBtn;

    public String countTheMails(){
        List<WebElement> mails = driver.findElements(By.name("farit.valiahmetov"));
        return Integer.toString(mails.size()/2);
    }


    public void clickNewMailBtn() {
        NewMailBtn.click(); }

}
