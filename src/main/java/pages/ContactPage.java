package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        setDriver (driver);
        PageFactory.initElements (new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy (xpath="//a[text()='CONTACTS']")
    WebElement btnContacts;
    @FindBy (xpath="//*[text()='ADD']")
    WebElement btnAdd;
    @FindBy (xpath="//button[text()='Sign Out']")
    WebElement btnSignOut;
    @FindBy (xpath="//div[@class='contact-page_message__2qafk']")
    WebElement noContacts;

    public boolean isTextSignOutPresent(String text) {
        return isTextElementPresent (btnSignOut, text);

    }

    public boolean isTextInBtnAddPresent(String text) {
        return isTextElementPresent (btnAdd, text);
    }

    public boolean isTextNoContactsHerePresent(String text) {
        return isTextElementPresent (noContacts, text);

    }
}
