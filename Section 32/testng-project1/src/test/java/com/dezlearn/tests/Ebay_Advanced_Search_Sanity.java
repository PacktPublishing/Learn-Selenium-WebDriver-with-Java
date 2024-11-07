package com.dezlearn.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ebay_Advanced_Search_Sanity extends AbstractBaseTest {
	
	@Test(groups = {"P0", "P1"})
	public void empty_advanced_search_test() throws Exception {
	
		App().Flow().navigateToUrl(App().Pages().AdvancedSearchPage().getPageUrl());
		
		String expectedURL = "https://www.ebay.com/v/allcategories";
		String expectedTitle = "All Categories - Browse and Discover more | eBay";

		Assert.assertTrue(App().Pages().AdvancedSearchPage().isAdvSearchButtonEnabled(), "Verify Search Button Enabled");

		App().Pages().AdvancedSearchPage().clickAdvSearchButton();

		String newUrl = App().Flow().getCurrentPageUrl();
		String newTitle = App().Flow().getCurrentPageTitle();
		System.out.println(newUrl);
		System.out.println(newTitle);

		Assert.assertEquals(newUrl, expectedURL, "Verify URL of the new page");
		Assert.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");
	}

	@Test(groups = {"P2", "P1"})
	public void category_options_in_ascending_order_test() throws Exception {
		
		App().Flow().navigateToUrl(App().Pages().AdvancedSearchPage().getPageUrl());
		
		List<WebElement> category_options = App().Pages().AdvancedSearchPage().getAllCatOptions();
		List<String> arr1 = new ArrayList<String>();

		for (WebElement option : category_options) {
			arr1.add(option.getText());
		}
		List<String> arr2 = new ArrayList<String>(arr1);
		Collections.sort(arr2);

		System.out.println("Actual List:" + arr1);
		System.out.println("Sorted List:" + arr2);
		Assert.assertTrue(arr1.equals(arr2), "Verify Category Items Sorted");
	}

	@Test(groups = {"P0"})
	public void ebay_logo_link_navigates_home_page_test() throws Exception {
		
		App().Flow().navigateToUrl(App().Pages().AdvancedSearchPage().getPageUrl());
		
		String expectedURL = "https://www.ebay.com/";
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";

		App().Pages().AdvancedSearchPage().clickOnEbayLogo();
		String newUrl = App().Flow().getCurrentPageUrl();
		String newTitle = App().Flow().getCurrentPageTitle();

		System.out.println(newUrl);
		System.out.println(newTitle);
		Assert.assertEquals(newUrl, expectedURL, "Verify URL of the new page");
		Assert.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");
	}

	@Test(groups = {"P3", "P1"})
	public void advanced_search_keywords_test() throws Exception {
		
		App().Flow().navigateToUrl(App().Pages().AdvancedSearchPage().getPageUrl());
		
		String keyword1 = "unlocked";
		String keyword2 = "ios";
		String searchString = keyword1 + " " + keyword2;

		App().Pages().AdvancedSearchPage().enterSearchStringInKeywordsField(searchString);
		App().Pages().AdvancedSearchPage().clickAdvSearchButton();

		String firstResultTitle = App().Pages().SearchResultsPage().getFirstResultTitle();
		
		Assert.assertTrue(firstResultTitle.toLowerCase().contains(keyword1),
				"Result Title Contains First Keyword " + keyword1);
		Assert.assertTrue(firstResultTitle.toLowerCase().contains(keyword2),
				"Result Title Contains Second Keyword " + keyword2);
	}
}
