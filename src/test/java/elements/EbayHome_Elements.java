/*
 *Class : Common Actions class
 *Author : VaibhavS
 */
package elements;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHome_Elements {
	
	WebDriver driver;

	@FindBy(css = "#gh-as-a") public WebElement advancedLink;
	@FindBy(css = "#gh-ac") public WebElement searchBox;
	@FindBy(css = ".btn.btn-prim.gh-spr") public WebElement searchButton;
	@FindBy(css = "h1.srp-controls__count-heading>span.BOLD:first-child") public WebElement numOfItems;
	@FindBy(css = "#gh-cat>option") public List<WebElement> catOptions;
	
	public EbayHome_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
