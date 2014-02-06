package com.od.jee.sample.todo;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("index.jsf")
public class HomePage {

	@Drone
	private WebDriver browser;

	@FindBy
	private TaskForm taskForm;

	@FindBy(id = "taskList")
	private WebElement taskList;

	public TaskForm getTaskForm() {
		return taskForm;
	}

	public String getTitle() {
		return browser.getTitle();
	}

	public String getTaskListText() {
		return taskList.getText();
	}

}
