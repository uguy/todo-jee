package com.od.jee.sample.todo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HomePageIT {

	private String baseUrl;
	private HomePage homePage;
	private WebDriver driver;

	@Before
	public void openBrowser() {
		baseUrl = System.getProperty("webapp.base.url");
		driver = new HtmlUnitDriver();
		driver.get(baseUrl);
		homePage = new HomePage(driver);
	}

	@Test
	public void pageTitleShouldMatchAppName() throws IOException {
		assertEquals("Todo", homePage.getTitle());
	}

}
