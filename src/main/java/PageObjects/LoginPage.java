package PageObjects;

//import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 import org.testng.Assert;
 //import java.testng.*;
//import org.testng.annotations.Test;




public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bt-split-screen__header")
    private WebElement loginHeaderTitle;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "next")
    private WebElement selanjutnyaButton;

    @FindBy(xpath = "//div[@class='bt-social-group']//button[1]")
    private WebElement loginFacebookButton;

    @FindBy(id = "btnGoogle")
    private WebElement loginGoogleButton;

    @FindBy(className = "bt-question-register")
    private WebElement registerQuestionText;

    @FindBy(xpath = "//a[@href='/register']")
    private WebElement registerLink;

    public boolean emailLoginPageIsDisplayed() {
        loginHeaderTitle.isDisplayed();
        emailField.isDisplayed();
        selanjutnyaButton.isDisplayed();
        loginFacebookButton.isDisplayed();
        loginGoogleButton.isDisplayed();
        registerQuestionText.isDisplayed();
        registerLink.isDisplayed();
        return true;
    }

    public String getLoginHeaderTitle() {
        loginHeaderTitle.isDisplayed();
        return loginHeaderTitle.getText();
    }

    public String getQuestionRegisterText() {
        registerQuestionText.isDisplayed();
        return registerQuestionText.getText();
    }

    public void fillEmailData(String email) {
        emailField.isEnabled();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickSelanjutnyaButton() {
        selanjutnyaButton.isEnabled();
        selanjutnyaButton.click();
    }

    public void launchSauceDemoWebsite() {
        By username = By.xpath("//*[@id = 'user-name']");
        By password = By.xpath("//*[@id = 'password']");
        By login = By.xpath("//*[@id = 'login-button']");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        WebElement Login = wait.until(ExpectedConditions.visibilityOfElementLocated(login));

        Username.sendKeys("standard_user");
        Password.sendKeys("secret_sauce");
        Login.click();

    }

    public void verifyTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By title = By.xpath("//*[text()='Products']");
        WebElement HomepageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        System.out.println("Tile: " + HomepageTitle.getText());
        Assert.assertTrue(HomepageTitle.isDisplayed());
    }

    public void userProvidedUsernameAndPassword(String username, String password) {
        By user = By.xpath("//*[@id = 'user-name']");
        By pass = By.xpath("//*[@id = 'password']");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(user));
        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(pass));

        Username.sendKeys(username);
        Password.sendKeys(password);
    }
}
