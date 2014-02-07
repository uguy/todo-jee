package com.od.jee.sample.todo;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@Drone
	private WebDriver driver;

	@FindBy
	private TaskForm taskForm;

	@FindBy(id = "taskList")
	private WebElement taskList;

	public TaskForm getTaskForm() {
		return taskForm;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getTaskListText() {
		return taskList.getText();
	}

}
