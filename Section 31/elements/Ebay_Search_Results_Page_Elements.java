package com.dezlearn.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebay_Search_Results_Page_Elements {
	
	WebDriver driver;

	@FindBy(xpath="//div[@id='ResultSetItems']/descendant::h3[1]") public WebElement firstSearchResult;
	
	public Ebay_Search_Results_Page_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
