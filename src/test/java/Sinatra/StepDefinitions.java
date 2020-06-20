package Sinatra;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.WebDriverFactory;

public class StepDefinitions {
    WebDriver webDriver;

    @Before
    public void initWebDriver() {
        webDriver = WebDriverFactory.getWebDriver(WebDriverFactory.Browser.Firefox);
    }

    @Given("I'm a user navigating on Google.com")
    public void navigateToHomaPage() {
        webDriver.get("http://www.google.com");
    }

    @When("I click on the Sign-In button")
    public void signIn() {
        WebElement webElement = webDriver.findElement(By.id("gb_70"));
        webElement.click();
    }

    @Then("the page must the display the login screen")
    public void setCredentials() {
        Assert.assertTrue(webDriver.getCurrentUrl().contains("accounts.google.com"));
    }

    @After
    public void closeWebDriver() {
        webDriver.quit();
    }
}