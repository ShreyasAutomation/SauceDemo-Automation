package StepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import PageObjects.E2EPage;

public class E2ESteps {
    public WebDriver driver;
    E2EPage e2epage;

    public E2ESteps(){
        this.driver = Hooks.getDriver();
    }

    @Then("Select the item {string} for Add To Cart")
    public void selectTheItemForAddToCart(String item) {
        e2epage = new E2EPage(driver);
        e2epage.selectTheItemForAddToCart(item);
    }

    @Then("user is able to see {string} title")
    public void userIsAbleToSeeTitle(String title) {
        e2epage = new E2EPage(driver);
        e2epage.userIsAbleToSeeTitle(title);
    }

    @Then("verify the cart items")
    public void verifyTheCartItems() {
        e2epage = new E2EPage(driver);
        e2epage.verifyTheCartItems();
    }

    @Then("user enters data {string} in {string} field")
    public void userEntersDataInField(String data, String field) {
        e2epage = new E2EPage(driver);
        e2epage.userEntersDataInField(data, field);
    }

    @Then("user is able to see the text {string}")
    public void userIsAbleToSeeTheText(String text) {
        e2epage = new E2EPage(driver);
        e2epage.userIsAbleToSeeTheText(text);
    }
}
