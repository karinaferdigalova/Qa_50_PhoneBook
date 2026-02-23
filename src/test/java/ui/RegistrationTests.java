package ui;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import static utils.UserFactory.*;
import java.util.Random;

public class RegistrationTests extends AppManager {
    LoginPage loginPage;
    @BeforeMethod
    public void goToRegistrationPage(){
        new HomePage(getDriver ()).clickBtnLogin ();
        loginPage = new LoginPage (getDriver ());
    }
    @Test
    public void registrationPositiveTest(){
        int i = new Random ().nextInt (1000);
        User user = User.builder ()
                .username ("karina"+i+"@gmail.com")
                .password ("Karina29!$")
                .build ();
        loginPage.typeLoginRegisUser (user);
        loginPage.clickBtnRegForm ();
        ContactPage contactPage = new ContactPage (getDriver ());
        Assert.assertTrue (contactPage.isTextSignOutPresent ("Sign Out"));
        Assert.assertTrue (contactPage.isTextNoContactsHerePresent ("No Contacts here!"));
    }
    @Test
    public void registrationWithFakerPositiveTest(){
        User user =positiveUser ();
        loginPage.typeLoginRegisUser (user);
        loginPage.clickBtnRegForm ();
        ContactPage contactPage = new ContactPage (getDriver ());
        Assert.assertTrue (contactPage.isTextSignOutPresent ("Sign Out"));
        Assert.assertTrue (contactPage.isTextNoContactsHerePresent ("No Contacts here!"));
    }

}
