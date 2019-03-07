package helpers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	
	public WebDriverFactory() {
		
	}
	
	static WebDriver create() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\work\\softwares\\chromedriver\\chromedriver.exe");
		return Drivers.valueOf("chrome".toUpperCase()).newDriver();
		
	}
	
	
	private enum Drivers{
		FIREFOX{
			@Override
			public WebDriver newDriver() {
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				return new FirefoxDriver(capabilities);
			}
		},
		CHROME{
			@Override
			public WebDriver newDriver() {
				System.setProperty("webdriver.chrome.driver","D:\\\\work\\\\softwares\\\\chromedriver\\\\chromedriver.exe");
				
				ChromeOptions options = new ChromeOptions();
				options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
				options.addArguments("--start-maximized");
				
				@SuppressWarnings("static-access")
				DesiredCapabilities chromeCapability = new DesiredCapabilities().chrome();
				chromeCapability.setJavascriptEnabled(true);
				chromeCapability.setBrowserName("chrome");
				chromeCapability.setPlatform(Platform.WINDOWS);
				chromeCapability.setCapability(ChromeOptions.CAPABILITY, options);
				
				return new ChromeDriver(chromeCapability);				
			}
		};

		/*
		 * public WebDriver newDriver() { // TODO Auto-generated method stub return
		 * null; }
		 */
		public abstract WebDriver newDriver();
	}

}
