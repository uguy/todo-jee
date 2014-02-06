package com.od.jee.sample.todo;

import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
}
