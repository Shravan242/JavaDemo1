package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	@FindBy(how=How.NAME, using="email")
	public WebElement regUsername;
	
	@FindBy(how=How.NAME, using="password")
	public WebElement regPassword;
	
	@FindBy(how=How.NAME, using="confirmPassword")
	public WebElement regConfPassword;
	
	@FindBy(how=How.NAME, using="register")
	public WebElement submitRegister;
	
	@FindBy(how=How.XPATH, using="//a[text()=\"REGISTER\"]")
	public WebElement registerUser;
	
}
