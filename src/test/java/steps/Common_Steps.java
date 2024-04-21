/*
 *Class : Common Actions class
 *Author : VaibhavS
 */
package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Common_Steps {
	
	private WebDriver driver;
	public static final String PathToDownloadFiles = System.getProperty("user.dir")+ File.separator+"downloadFiles";

	@Before()
	public void setUp() {
		driver =  createWebDriver("chrome");
		log.info("Global Before Hook Executed");
	}
	

	@After()
	public void tearDown(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			//Take Screenshot
			final byte[] shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//Embed into Report
			scenario.attach(shot, "image/png", scenario.getName());
		}
		driver.quit();
		Thread.sleep(1000);
		log.info("Global After Hook Executed");
	}


	/*
	 * Method :  Select WebBrowser
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/*
	 * Method :  Select WebBrowser
	 */
	public static WebDriver createWebDriver(String browser){
		switch (browser){
			case "chrome":
				return new ChromeDriver(new ChromeOptions());
			case "firefox":
				return  new FirefoxDriver();
			default :
				throw new RuntimeException("Unsupported webdriver : "+ browser);
		}
	}


	/*
	 * Method :  setting up the chrome browser setting
	 */
	public static ChromeOptions chromeOptions(){
		Map<String,Object> chromePrefs =new HashMap<>();
		chromePrefs.put("profile.default_content_setting.popups",0);
		chromePrefs.put("download.default_directory",PathToDownloadFiles);

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs",chromePrefs);
		return chromeOptions;
	}

}