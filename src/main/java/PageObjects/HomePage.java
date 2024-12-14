package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage {
    WebDriver driver;


//    public HomePage(WebDriver webDriver) {
//        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
//    }
public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

    @FindBy(xpath = "//header//img[@alt='Bhinneka.com']//parent::a")
    private WebElement headerLogoButton;

    @FindBy(xpath ="//div[contains(@placeholder,'Cari produk asli')]//div//input")
    private WebElement searchInput;

    @FindBy(xpath = "//a[contains(@href,'/cart')]")
    private WebElement cartButton;

    @FindBy(xpath = "//img[contains(@src,'bhinneka-logo')]//parent::a//following-sibling::div")
    private WebElement bhinnekaCopyrightFooter;

    @FindBy(xpath = "//span[contains(text(),'Login')]//parent::button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@placeholder,'Cari produk asli')]//div//a")
    private WebElement searchProductLink;

    @FindBy(xpath = "//*[invalid locators]")
    private WebElement invalidLocators;

    public boolean defaultHomePageIsDisplayed() {
        headerLogoButton.isDisplayed();
        searchInput.isDisplayed();
        cartButton.isDisplayed();
        bhinnekaCopyrightFooter.isDisplayed();
        return true;
    }

    public void clickLoginButton() {
        loginButton.isDisplayed();
        loginButton.isEnabled();
        loginButton.click();
    }

    public void clickCartButton() {
        cartButton.isEnabled();
        cartButton.click();
    }

    public void setSearchInput(String product) {
        searchInput.isEnabled();
        searchInput.click();
        searchInput.sendKeys(product);
    }

    public String getSearchProductLink() {
        searchProductLink.isDisplayed();
        return searchProductLink.getText();
    }

    public void getInvalidLocators() {
        invalidLocators.isDisplayed();
    }

    public void searchProductData(String product) {

        setSearchInput(product);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void verifyingTheListItemsInHomepage() throws InterruptedException {
        List<String> list = Arrays.asList("All Items", "About", "Logout", "Reset App State");

        By hamburger = By.xpath("//div[@class = 'bm-burger-button']");
        By listItems = By.xpath("//nav[@class='bm-item-list']/a");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement HamBurger = wait.until(ExpectedConditions.
                visibilityOfElementLocated(hamburger));
        HamBurger.click();

        List<WebElement> ListItems = driver.findElements(listItems);

        Thread.sleep(3000);
        for(WebElement ele : ListItems){
            Assert.assertTrue(list.contains(ele.getText()));
            Assert.assertEquals(ListItems.size(), 4);
            System.out.println(ele.getText());
            Thread.sleep(3000);
        }
    }

    public void userClicksOnButton(String btn) throws InterruptedException {
        By button = By.xpath("//button[text()='"+btn+"']/../../div | //a[text()='"+ btn +"'] |  //input[@value = '"+btn+"'] | //a[contains(@class, '"+btn+"')]/*[local-name()='svg'] ");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement Button = wait.until(ExpectedConditions.visibilityOfElementLocated(button));
        Button.click();
        Thread.sleep(3000);
    }

    public void userIsAbleToSeeButton(String btn) throws InterruptedException {
        By button = By.xpath("//a[text()='"+ btn +"'] | //input[@value = '"+btn+"'] ");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement Button = wait.until(ExpectedConditions.visibilityOfElementLocated(button));

        try{
            Assert.assertTrue(Button.isDisplayed());
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
