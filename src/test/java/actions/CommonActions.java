/*
  *Class : Common Actions class
  *Author : VaibhavS
 */
package actions;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Common_Steps;
import steps.ConfigGenerator;
import steps.ConfigMapper;
import java.time.Duration;


@Slf4j
public class CommonActions {

	private WebDriver driver;
	protected static ConfigMapper config;
	Common_Steps common_steps;
	private static WebDriverWait wait;

	public CommonActions(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
		config = new ConfigGenerator().getUIConfig();
		CommonActions.wait =  new WebDriverWait(driver, Duration.ofSeconds(30));
	}


	/*
	 * Method : redirect to the main page
	 */
	public void startNavigation() {
		driver.get(config.getBaseApiUri());
	}

	public String landingPageURI() {
		return config.getBaseApiUri();
	}

	/*
	 * Method : to redirect to the page
	 */
	public void goToUrl(String url) {
		driver.get(url);
	}


	/*
	 * Method : to get the current page url
	 */
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}


	/*
	 * Method : to get the current page title
	 */
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}


	/*
	 * Method : to pausing process for milli seconds
	 */
	public void sleep (int seconds){
		long secondsLong = (seconds *1000L);
		log.info("waiting for {} milli-seconds",secondsLong);
		try{
			Thread.sleep(secondsLong);
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	/*
	 * Method :  wait until Element visible
	 */
	public void waitForElementToVisible(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * Method :  wait until Element clickable
	 */
	public void waitForElementToClick(By by){
		wait.until(ExpectedConditions.elementToBeClickable((By) by));
	}

}
