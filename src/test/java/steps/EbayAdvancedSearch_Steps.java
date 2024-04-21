package steps;

import static org.junit.Assert.fail;

import actions.CommonActions;
import actions.EbayAdvancedSearch_Actions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class EbayAdvancedSearch_Steps {
	CommonActions common_actions;
	EbayAdvancedSearch_Actions ebayadvancedsearch_actions;
	
	public EbayAdvancedSearch_Steps(CommonActions common_actions, EbayAdvancedSearch_Actions ebayadvancedsearch_actions) {
		this.common_actions = common_actions;
		this.ebayadvancedsearch_actions = ebayadvancedsearch_actions;
	}
	
	@Given("User is on ebay advanced search page")
	public void user_is_on_ebay_advanced_search_page() {
		common_actions.goToUrl(common_actions.landingPageURI()+"sch/ebayadvsearch");
	}

	@When("User click on ebay logo")
	public void user_click_on_ebay_logo() {
		ebayadvancedsearch_actions.clickOnEbayLogo();
	}

	@Then("Page navigated to ebay home page")
	public void page_navigated_to_ebay_Home_page() {
	   // String expUrl = "https://www.ebay.com/";
		String expUrl = common_actions.landingPageURI();
	    String actUrl = common_actions.getCurrentPageUrl();
		Assert.assertTrue("Expected navigation URL is not matching",expUrl.equals(actUrl));
	}
	
	@When("User did advanced search")
	public void User_did_advanced_search(DataTable dataTable) throws Exception {
		ebayadvancedsearch_actions.enterSearchString(dataTable.cell(1, 0));
		ebayadvancedsearch_actions.enterExcludeString(dataTable.cell(1, 1));
		ebayadvancedsearch_actions.enterMinPrice(dataTable.cell(1, 2));
		ebayadvancedsearch_actions.enterMaxPrice(dataTable.cell(1, 3));
		ebayadvancedsearch_actions.clickOnSearchBtn();
	}
}
