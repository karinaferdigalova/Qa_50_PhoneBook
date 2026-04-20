package ui;

import dto.Contact;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.HeaderMenuItem;

import static pages.BasePage.*;
import static utils.ContactFactory.*;


public class AddNewContactTest extends AppManager {
    HomePage homePage;
    LoginPage loginPage;
    ContactPage contactPage;
    AddPage addPage;
    int countOfContacts;

    @BeforeMethod
    public void login() {
        homePage = new HomePage (getDriver ());
        loginPage = clickButtonHeader (HeaderMenuItem.LOGIN);
        loginPage.typeLoginRegistrationForm ("karina2902@gmail.com", "Karina29!$");
        loginPage.clickBtnLoginForm ();
        contactPage = new ContactPage (getDriver ());
        countOfContacts = contactPage.getCountsContacts ();
        addPage = clickButtonHeader (HeaderMenuItem.ADD);

    }
    @Test
    public void addNewContactPositive() {
//        addPage = new AddPage (getDriver ());
        addPage.typeContactForm (positiveContact ());
        int countOfContactsAfterAdd = contactPage.getCountsContacts ();
        Assert.assertEquals (countOfContactsAfterAdd, countOfContacts + 1);


    }
    @Test
    public void addNewContactPositive_clickLastContact() {
        Contact contact = positiveContact ();
        addPage.typeContactForm (contact);
        //contactPage.clickLastContact();
        Assert.assertTrue (contactPage.isContactPresent (contact));
    }
    @Test
    public void scrollToLastContact() {
        Contact contact = positiveContact ();
        addPage.typeContactForm (contact);
        contactPage.scrollToLastContact ();

    }
}
