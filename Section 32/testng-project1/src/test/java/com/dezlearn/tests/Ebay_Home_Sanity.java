package com.dezlearn.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.testng.Assert;

public class Ebay_Home_Sanity extends AbstractBaseTest {

	@Test(groups = {"P0"})
	public void empty_search_test() throws Exception {
		
		App().Flow().navigateToUrl(App().Pages().HomePage().getPageUrl());
		
		String expectedURL = "https://www.ebay.com/v/allcategories";
		String expectedTitle = "All Categories - Browse and Discover more | eBay";

		Assert.assertTrue(App().Pages().HomePage().isSearchButtonEnabled(), "Verify Search Button Enabled");

		App().Pages().HomePage().clickSearchButton();
		Thread.sleep(2000);
		String newUrl = App().Flow().getCurrentPageUrl();
		String newTitle = App().Flow().getCurrentPageTitle();
		System.out.println(newUrl);
		System.out.println(newTitle);

		Assert.assertEquals(newUrl, expectedURL, "Verify URL of the new page");
		Assert.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");

	}

	@Test(groups = {"P2", "P3"})
	public void empty_search_test_softassert() throws Exception {
		
		App().Flow().navigateToUrl(App().Pages().HomePage().getPageUrl());

		SoftAssert sa = new SoftAssert();

		String expectedURL = "https://www.ebay.com/v/allcategories";
		String expectedTitle = "All Categories - Browse and Discover more | eBay";

		sa.assertTrue(App().Pages().HomePage().isSearchButtonEnabled(), "Verify Search Button Enabled");

		App().Pages().HomePage().clickSearchButton();
		
		String newUrl = App().Flow().getCurrentPageUrl();
		String newTitle = App().Flow().getCurrentPageTitle();
		System.out.println(newUrl);
		System.out.println(newTitle);

		sa.assertEquals(newUrl, expectedURL, "Verify URL of the new page");
		sa.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");

		sa.assertAll();
	}
}