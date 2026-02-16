package ui;

import dto.User;
import manager.AppManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {

    @Test
    public void loginPositive() {
        HomePage homePage = new HomePage (getDriver ());
        homePage.clickBtnLogin ();
        LoginPage loginPage = new LoginPage (getDriver ());
        loginPage.typeLoginRegistrationForm ("karina2902@gmail.com", "Karina29!$");
        loginPage.clickBtnLoginForm ();


    }

    @Test
    public void loginPositiveUser() {
        User user = new User ("karina2902@gmail.com", "Karina29!$");
        HomePage homePage = new HomePage (getDriver ());
        homePage.clickBtnLogin ();
        LoginPage loginPage = new LoginPage (getDriver ());
        loginPage.typeLoginRegisUser (user);
        loginPage.clickBtnLoginForm ();



    }


}
