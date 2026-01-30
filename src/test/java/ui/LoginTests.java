package ui;

import manager.AppManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends AppManager {

    @Test
    public void loginPositive(){
        HomePage homePage = new HomePage (getDriver());
        homePage.clickBtnLogin ();
    }
    @FindBy(xpath = "//a[text()'LOGIN'])")
    WebElement btnLogin;


}
