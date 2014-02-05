package com.od.jee.sample.todo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HomePageIT {

	private String baseUrl;
	private WebDriver driver;

	@Before
	public void openBrowser() {
		baseUrl = System.getProperty("webapp.base.url");
		driver = new HtmlUnitDriver();
		driver.get(baseUrl);
	}

	@Test
	public void pageTitleShouldMatchAppName() {
		assertEquals("Todo", driver.getTitle());
	}

}
