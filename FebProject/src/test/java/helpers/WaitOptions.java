package helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitOptions {
	
	WebDriverWait wait;
	WebDriver driver;
	
	public static WebElement waitForElement(WebDriver driver, WebElement fElement) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(100, TimeUnit.SECONDS)
									.pollingEvery(100, TimeUnit.MILLISECONDS)
									.ignoring(NoSuchElementException.class,StaleElementReferenceException.class);
		
		WebElement fWebEle = wait.until(new Function<WebDriver, WebElement>()
				{
					public WebElement apply(WebDriver driver) {
						if(fElement.isEnabled()) {
							return fElement;
						}
						else {
							return null;
						}
					}
				}				
				);
		
		return fWebEle;		
	}
}
