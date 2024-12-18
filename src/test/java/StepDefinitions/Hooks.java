package StepDefinitions;

import Managers.FileReaderManager;
import Utilities.TestContext;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Hooks {

//    TestContext testContext;
//    WebDriver webDriver;
//
//    public Hooks(TestContext context) {
//        testContext = context;
//    }
//
//    @Before
//    public void setUp() {
//        webDriver = testContext.getDriverManager().getDriver();
//        webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
//    }
//
//    @After
//    public void tearDown(Scenario scenario) {
//
//        if(scenario.isFailed()) {
//            try {
//                byte[] screenshot = ((TakesScreenshot)testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "image/png", "screenshot");
//            } catch (WebDriverException noSupportScreenshot) {
//                System.err.println(noSupportScreenshot.getMessage());
//            }
//        }
//        testContext.getDriverManager().closeDriver();
//    }

    private static WebDriver driver;
    private static ExtentReports extentReports;
    private static ExtentSparkReporter sparkReporter;
    public static ExtentTest test;


    static {
        sparkReporter = new ExtentSparkReporter("target/ExtentReports/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        // Configure the report
        sparkReporter.config().setDocumentTitle("Test Execution Report");
        sparkReporter.config().setReportName("Regression Test Suite");
        sparkReporter.config().setTheme(Theme.STANDARD);
    }

    @Before
    public void setup(Scenario scenario){
        test = extentReports.createTest(scenario.getName());

        if (driver == null) {
         //   System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/v1/index.html");
            driver.manage().window().maximize();

        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            test.fail("Test Failed: " + scenario.getName());
        }else{
            test.pass("Test Passed: " + scenario.getName());
        }

        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }

        // Flush the report after each test run
     //   extentReports.flush();
    }

    @After
    public void flushReports() {
        extentReports.flush();
    }
}
