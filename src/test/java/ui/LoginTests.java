package ui;

import dto.User;
import manager.AppManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import utils.RetryAnalyser;
import static utils.PropertiesReader.*;

public class LoginTests extends AppManager {

    @Test(retryAnalyzer = RetryAnalyser.class)
    public void loginPositive() {
        HomePage homePage = new HomePage (getDriver ());
        homePage.clickBtnLogin ();
        LoginPage loginPage = new LoginPage (getDriver ());
       // loginPage.typeLoginRegistrationForm ("karina2902@gmail.com", "Karina29!$");
        loginPage.typeLoginRegistrationForm (getProperty ("base.properties","login"),
        getProperty ("base.properties","password"));
        loginPage.clickBtnLoginForm ();
        ContactPage contactPage = new ContactPage (getDriver ());
        Assert.assertTrue (contactPage.isTextInBtnAddPresent ("ADD"));


    }

    @Test
    public void loginPositiveUser() {
        HomePage homePage = new HomePage (getDriver ());
        homePage.clickBtnLogin ();
        LoginPage loginPage = new LoginPage (getDriver ());
        loginPage.typeLoginRegistrationForm (getProperty ("base.properties","login"),
                getProperty ("base.properties","password"));
        loginPage.clickBtnLoginForm ();
        ContactPage contactPage = new ContactPage (getDriver ());
        Assert.assertTrue (contactPage.isTextSignOutPresent ("Sign Out"));

    }

    @Test
    public void loginNegativeTestsWrongEmail() {
        User user = User.builder ()
                .username ("karina2mail.com")
                .password ("Karina29!$")
                .build ();

        HomePage homePage = new HomePage (getDriver ());
        homePage.clickBtnLogin ();
        LoginPage loginPage = new LoginPage (getDriver ());
        loginPage.typeLoginRegisUser (user);
        loginPage.clickBtnLoginForm ();
        Assert.assertEquals (loginPage.closeAlertReturnText (), "Wrong email or password");
    }

    @Test
    public void loginNegativeTestsWrongPassword() {
        User user = User.builder ()
                .username ("karina292002@gmail.com")
                .password ("Karina")
                .build ();

        HomePage homePage = new HomePage (getDriver ());
        homePage.clickBtnLogin ();
        LoginPage loginPage = new LoginPage (getDriver ());
        loginPage.typeLoginRegisUser (user);
        loginPage.clickBtnLoginForm ();
        Assert.assertEquals (loginPage.closeAlertReturnText (), "Wrong email or password");

    }


}
