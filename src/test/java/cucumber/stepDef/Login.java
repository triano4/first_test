package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseUrl= "http://www.saucedemo.com/";

//  Positive test
    @Given("Login to application")
    public void user_is_on_login_page(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt= new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @When("user input (.*) as username$")
    public void user_input_username(String username){
        driver.findElement(By.id("user-name")).sendKeys(username);
    }
    @And("user input (.*) as password$")
    public void user_input_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @And("user click submit")
    public void user_input_submit(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @Then("Homepage should be displayed")
    public void homepage_success(){
        driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        driver.quit();
    }

//  Negative test
    @Given("Login to applications")
    public void user_on_login_page(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt= new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @When("user input invalid user (.*) as invalidusername$")
    public void user_input_invalid_user(String invalidusername){
        driver.findElement(By.id("user-name")).sendKeys(invalidusername);
    }
    @And("user input invalid pass (.*) as invalidpassword$")
    public void user_input_invalid_password(String invalidpassword){
        driver.findElement(By.id("password")).sendKeys(invalidpassword);
    }
    @And("user click submits")
    public void user_click_submit(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @Then("error should be displayed")
    public void homepage_fail(){
        driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface')]"));
        driver.quit();
    }

}
