package actions;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import helpers.WaitOptions;
import pageObjects.LoginPage;

public class LoginPageActions extends WaitOptions {
	
	WebDriver driver;
	LoginPage loginPage;
	
	public LoginPageActions(WebDriver driver) {
		this.driver = driver;
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}
	
	public void registerUser() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\file\\login.properties"));
		
		driver.get(prop.getProperty("MERCURY_URL"));
				
		loginPage.registerUser.click();
		waitForElement(driver, loginPage.regUsername);
		loginPage.regUsername.sendKeys(prop.getProperty("DUSERNAME"));
		loginPage.regPassword.sendKeys(prop.getProperty("DPASSWORD"));
		loginPage.regConfPassword.sendKeys(prop.getProperty("DCONPASSWORD"));
		loginPage.submitRegister.click();
	}

}
