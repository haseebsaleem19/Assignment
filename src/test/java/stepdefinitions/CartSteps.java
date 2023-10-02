package stepdefinitions;

import io.cucumber.java.en.*;
import org.assignment.pages.LoginPage;
import org.assignment.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

public class CartSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public CartSteps() {
        this.driver = WebDriverFactory.getDriver(); // Initialize your WebDriver
        this.loginPage = new LoginPage(driver);
    }

    @Given("I am logged in to the Saucedemo website")
    public void iAmLoggedInToTheWebsite() {
        driver.get("https://www.saucedemo.com/");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
    }

    @When("I add {string} to the cart")
    public void iAddProductToTheCart(String productName) {
        WebElement productToAdd = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
        WebElement addToCartButton = productToAdd.findElement(By.xpath("./ancestor::div[@class='inventory_item']//button[text()='Add to cart']"));
        addToCartButton.click();
    }

    @When("I remove {string} from the cart")
    public void iRemoveProductFromTheCart(String productName) {
        // Click on the shopping cart icon to open the cart
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
        cartIcon.click();

        // Find the product to remove in the cart and click the remove button
        WebElement productToRemove = driver.findElement(By.xpath("//div[@class='cart_item_label']//div[@class='inventory_item_name' and text()='" + productName + "']"));
        WebElement removeButton = productToRemove.findElement(By.xpath("./ancestor::div[@class='cart_item']//button[text()='Remove']"));
        removeButton.click();
    }

    @Then("the cart should contain {string}")
    public void theCartShouldContain(String productName) {
        WebElement cartItem = driver.findElement(By.xpath("//div[@class='cart_item_label']//div[@class='inventory_item_name' and text()='" + productName + "']"));
        assertNotNull(cartItem);
    }

    @Then("the cart should not contain {string}")
    public void theCartShouldNotContain(String productName) {
        // Find all elements that match the given XPath
        List < WebElement > cartItems = driver.findElements(By.xpath("//div[@class='cart_item_label']//div[@class='inventory_item_name']"));

        // Check if the list of elements contains the product name
        assertFalse("The cart should not contain " + productName, cartItems.stream().anyMatch(item -> item.getText().equals(productName)));
    }

    @When("I log out")
    public void iLogOut() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement burgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        Actions actions = new Actions(driver);
        actions.moveToElement(burgerMenuButton).click().perform();
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutLink.click();
        driver.quit();
    }
}