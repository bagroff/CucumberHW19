package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestDefinitions {
    private ChromeDriver chromeDriver;

    @Before
    public void init() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @Given("I open Login page {string}")
    public void openLoginPage(String url) {
        chromeDriver.get(url);
    }

    @When("I enter my {string} on the Login page")
    public void enterUserName(String userName) {
        chromeDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(userName);
    }

    @When("I enter my valid {string} to the Login page")
    public void enterPassword(String userPassword) {
        chromeDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div/input")).sendKeys(userPassword);
    }

    @When("I enter my {string} username and invalid {string} password on the Login page")
    public void invalidLoginAndPassword(String name, String pass) {
        chromeDriver.findElement(By.id("username")).sendKeys(name);
        chromeDriver.findElement(By.id("password")).sendKeys(pass);
    }

    @When("I click on Login button on the Login page")
    public void loginButton() {
        chromeDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
    }

    @Then("I should successfully logged to the Login page")
    public void successLogin() {
        chromeDriver.findElement(By.xpath("//div[contains(text(), 'You logged into a secure area!')]"));
    }

    @Then("I shouldn't successfully logged to the Login page")
    public void unSuccessLogin() {
        chromeDriver.findElement(By.xpath("//div[contains(text(), 'Your username is invalid!')]"));
    }

    @After
    public void tearDown() {
        chromeDriver.quit();
    }
}
