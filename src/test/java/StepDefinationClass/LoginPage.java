package StepDefinationClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	static WebDriver driver;
@Given("usre is on reg page")
public void usre_is_on_reg_page() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.facebook.com/reg");
}

@When("user enter valid firstname and last name")
public void user_enter_valid_firstname_and_last_name() {
	 driver.findElement(By.name("firstname")).sendKeys("Geetesh");
	    driver.findElement(By.name("lastname")).sendKeys("Geetesh");

}

@When("user enter valid username and password")
public void user_enter_valid_username_and_password() {
	  driver.findElement(By.name("reg_email__")).sendKeys("Geetesh@123");
	    driver.findElement(By.name("reg_passwd__")).sendKeys("Geetesh12");
}

@When("user enter valid Dob")
public void user_enter_valid_dob() {
	WebElement day = driver.findElement(By.name("birthday_day"));
	new Select(day).selectByVisibleText("23");

	
	WebElement month = driver.findElement(By.name("birthday_month"));
	new Select(month).selectByVisibleText("Sep");

	WebElement year = driver.findElement(By.name("birthday_year"));
		new Select(year).selectByVisibleText("1999");
}


}

