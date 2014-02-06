package com.od.jee.sample.todo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HomePageIT {

	private String baseUrl;
	private HomePage homePage;

	@Before
	public void openBrowser() {
		baseUrl = System.getProperty("webapp.base.url");
		WebDriver driver = new HtmlUnitDriver();
		driver.get(baseUrl);
		homePage = new HomePage(driver);
	}

	@Test
	public void pageTitleShouldMatchAppName() {
		assertEquals("Todo", homePage.getTitle());
	}

}
