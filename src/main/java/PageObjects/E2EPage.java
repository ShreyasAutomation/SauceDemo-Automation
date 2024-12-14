package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class E2EPage {
    public WebDriver driver;

    public E2EPage(WebDriver driver) {
        this.driver = driver;
    }


    public void selectTheItemForAddToCart(String Item) {
        By item = By.xpath("//div[text()='"+ Item +"']/../../following-sibling::div/button");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement selectedItem =  wait.until(ExpectedConditions.
                                visibilityOfElementLocated(item));

        selectedItem.click();
    }

    public void userIsAbleToSeeTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By Title = By.xpath("//div[@class= 'subheader']");
        WebElement PageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Title));
        System.out.println("Tile: " + PageTitle.getText());
        try {
            Assert.assertTrue(PageTitle.getText().contains(title) & PageTitle.isDisplayed());
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void verifyTheCartItems() {
        List<String> cartItems = Arrays.asList("Sauce Labs Backpack", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bolt T-Shirt");
        By items = By.xpath("//div[@class='cart_item']//a/div");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        List<WebElement> CartItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(items));

        for(WebElement element : CartItems){
            System.out.println("Cart Items: " + element.getText());
            Assert.assertTrue(cartItems.contains(element.getText()));
        }
    }

    public void userEntersDataInField(String data, String field) {
        By inputField = By.id(field);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement Field = wait.until(ExpectedConditions.visibilityOfElementLocated(inputField));

        Field.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        Field.sendKeys(data);
    }

    public void userIsAbleToSeeTheText(String Text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By msg = By.xpath("//*[contains(text(), '"+ Text +"')]");
        WebElement Pagemsg = wait.until(ExpectedConditions.visibilityOfElementLocated(msg));
        System.out.println("Tile: " + Pagemsg.getText());
        try {
            Assert.assertTrue(Pagemsg.getText().contains(Text) & Pagemsg.isDisplayed());
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}