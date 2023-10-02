package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.assignment.pages.LoginPage;
import org.assignment.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import io.cucumber.java.en.And;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = WebDriverFactory.getDriver(); // Initialize your WebDriver
        this.loginPage = new LoginPage(driver);
    }

    @Given("I am on the Saucedemo login page")
    public void userIsOnLoginPage() {
        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");
    }

    @And("User clicks the login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }
    @When("I enter my username as {string}")
    public void iEnterMyUsername(String username) {
        loginPage.enterUsername(username);
    }
    @When("I enter my password as {string}")
    public void iEnterMyPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        // Assert the presence of the element with class "title"
        WebElement titleElement = driver.findElement(By.xpath("//span[@class='title']"));
        assertTrue(titleElement.isDisplayed());
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assertTrue(errorMessage.isDisplayed());
    }
}