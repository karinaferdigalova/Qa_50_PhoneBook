package pages;

import dto.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        setDriver (driver);
        PageFactory.initElements (new AjaxElementLocatorFactory (driver, 10), this);
    }

    @FindBy (xpath="//a[text()='CONTACTS']")
    WebElement btnContacts;
    @FindBy (xpath="//*[text()='ADD']")
    WebElement btnAdd;
    @FindBy (xpath="//button[text()='Sign Out']")
    WebElement btnSignOut;
    @FindBy (xpath="//div[@class='contact-page_message__2qafk']")
    WebElement noContacts;
    @FindBy (className="contact-item_card__2SOIM")
    List<WebElement> contactList;
    @FindBy (xpath="//div[@class='contact-item_card__2SOIM'][last()]")
    WebElement lastContact;

    public boolean isContactPresent(Contact contact) {
        for (WebElement element : contactList) {
            if (element.getText ().contains (contact.getName ()) && element.getText ().contains (contact.getPhone ())) {
                System.out.println (element.getText ());
                return true;
            }
        }
        return false;
    }
    public int getCountsContacts() {
        return contactList.size ();
    }

    public boolean isTextSignOutPresent(String text) {
        return isTextElementPresent (btnSignOut, text);

    }

    public boolean isTextInBtnAddPresent(String text) {
        return isTextElementPresent (btnAdd, text);
    }

    public boolean isTextNoContactsHerePresent(String text) {
        return isTextElementPresent (noContacts, text);

    }
    public void clickLastContact() {
        lastContact.click ();

    }
}
