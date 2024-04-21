package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EabyAdvancedSearch_Elements {
	
	WebDriver driver;
	
	@FindBy(css = "a#gh-la") public WebElement ebayLogo;
	@FindBy(css = "input[data-testid$='_nkw']") public WebElement searchString;
	@FindBy(css = "input[name$='_ex_kw']") public WebElement excludeString;
	@FindBy(css = "input[name$='_udlo']") public WebElement minPrice;
	@FindBy(css = "input[name$='_udhi']") public WebElement maxPrice;
	@FindBy(css = ".adv-form__actions>.btn.btn--primary") public WebElement srchBtn;
	
	public EabyAdvancedSearch_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
