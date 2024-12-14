package StepDefinitions;

import PageObjects.HomePage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeSteps {

    HomePage homePage;
    TestContext testContext;
    WebDriver driver;



//    public HomeSteps(TestContext context) {
//        testContext = context;
//        homePage = testContext.getPageObjectManager().getHomePage();
//    }

    public HomeSteps(){
        this.driver = Hooks.getDriver();
    }

    @Given("Home page without authorizations")
    public void homePageWithoutAuthorizations() {
        Assert.assertTrue(homePage.defaultHomePageIsDisplayed());
    }

    @Given("Login form in login page")
    public void goToLoginPage() {
        Assert.assertTrue(homePage.defaultHomePageIsDisplayed());
        homePage.clickLoginButton();
    }

    @Then("This is for invalid locators")
    public void thisIsForInvalidLocators() {
        homePage.getInvalidLocators();
    }

    @Then("verifying the list items in Homepage")
    public void verifyingTheListItemsInHomepage() throws InterruptedException {
            homePage = new HomePage(driver);
            homePage.verifyingTheListItemsInHomepage();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String btn) throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.userClicksOnButton(btn);
    }

    @Then("user is able to see {string} button")
    public void userIsAbleToSeeButton(String btn) throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.userIsAbleToSeeButton(btn);
    }
}
