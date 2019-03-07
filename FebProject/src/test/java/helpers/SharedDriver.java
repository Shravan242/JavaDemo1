package helpers;

import org.openqa.selenium.WebDriver;

public class SharedDriver {
	
	private static WebDriver REAL_DRIVER;
	
	static {
  	  
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
				  	REAL_DRIVER.close();
		            REAL_DRIVER.quit();
//					Log.info("Driver is closed");
				} catch (Exception e) {
//					Log.error("Driver is closed in Exception , Driver Instance :" + REAL_DRIVER + "Ex. Message:"
//							+ e.getMessage());
					e.getMessage();
				}
			}
		});

    }
	
	
	

}
