/*
 *Class : Common Actions class
 *Author : VaibhavS
 */
package steps;

import actions.CommonActions;
import actions.EbayHomePageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class EbayHome_Steps {
	CommonActions commonActions;
	EbayHomePageActions ebayHomePageActions;

	public EbayHome_Steps(CommonActions commonActions, EbayHomePageActions ebayHomePageActions) {
		this.commonActions = commonActions;
		this.ebayHomePageActions = ebayHomePageActions;
	}

	@Given("User visit ebay home page")
	public void user_visit_ebay_home_page() {
		commonActions.startNavigation();
	}

	@When("User click on advance link")
	public void user_click_on_advance_link() {
		ebayHomePageActions.clickAdvancedLink();
	}

	@Then("User navigate to advanced search page")
	public void user_navigate_to_advanced_search_page() {
		String expUrl = "https://www.ebay.com/sch/ebayadvsearch";
		String actUrl = commonActions.getCurrentPageUrl();
		Assert.assertTrue("Expected navigation URL is not matching",expUrl.equals(actUrl));
	}

	@When("User search {string}")
	public void user_search(String searchStr) {
		ebayHomePageActions.searchAnItem(searchStr);
		ebayHomePageActions.clickSearchButton();
		commonActions.sleep(1);
	}

	@Then("Verify that search result count more than {int} item search")
	public void verify_that_search_result_count_more_than_item_search(int expectedCount) {
		int totalSearchCount = ebayHomePageActions.getSeatchItemsCount();
		log.info("Total Search Count {} " , totalSearchCount);
		Assert.assertFalse("Total search product count is less than at least expected count",(totalSearchCount<=expectedCount));
	}

	@When("User search {string} in {string}")
	public void user_search_in_category(String productName, String productCategory) {
		ebayHomePageActions.searchAnItem(productName);
		ebayHomePageActions.selectCategoryOption(productCategory);
		ebayHomePageActions.clickSearchButton();
		commonActions.sleep(1);
	}

	@When("User click on {string}")
	public void user_click_on(String string) {
		ebayHomePageActions.clickOnLinkByText(string);
		commonActions.sleep(1);
	}

	@Then("Verify that page navigates to {string} and title contains {string}")
	public void verify_that_page_navigates_to_and_title_contains(String url, String title) {
		String actUrl = commonActions.getCurrentPageUrl();
		String actTitle = commonActions.getCurrentPageTitle();
    	Assert.assertTrue("Expected navigate page url is not matching",(actUrl.equals(url)));
		Assert.assertTrue("Expected page title is not matching ",(actTitle.contains(title)));
	}
}