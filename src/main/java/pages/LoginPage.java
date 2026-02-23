package pages;

import dto.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        setDriver (driver);
        PageFactory.initElements (new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy (css="*[name='email']")
    WebElement inpEmail;
    @FindBy (css="*[name='password']")
    WebElement inpPassword;
    @FindBy (xpath="//button[text()='Login']")
    WebElement btnLoginForm;
    @FindBy (xpath="//button[text()='Registration']")
    WebElement btnRegForm;

    public String closeAlertReturnText() {
        Alert alert = new WebDriverWait (driver, Duration.ofSeconds (10))
                .until (ExpectedConditions.alertIsPresent ());
        String text = alert.getText ();
        alert.accept ();
        return text;
    }

    public void typeLoginRegistrationForm(String email, String password) {
        inpEmail.sendKeys (email);
        inpPassword.sendKeys (password);

    }

    public void typeLoginRegisUser(User user) {
        inpEmail.sendKeys (user.getUsername ());
        inpPassword.sendKeys (user.getPassword ());
    }


    public void clickBtnLoginForm() {
        btnLoginForm.click ();
    }

    public void clickBtnRegForm() {
        btnRegForm.click ();
    }
}
