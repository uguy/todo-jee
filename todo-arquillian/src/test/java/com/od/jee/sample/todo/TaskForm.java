//package com.od.jee.sample.todo;
//
//import org.jboss.arquillian.graphene.fragment.Root;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//public class TaskForm {
//
//	@Root
//	private WebElement taskForm;
//
//	@FindBy(id = "taskForm:title")
//	private WebElement titleInput;
//
//	@FindBy(id = "taskForm:description")
//	private WebElement descInput;
//
//	@FindBy(id = "taskForm:register")
//	private WebElement saveButton;
//
//	public void newTask(String title, String desc) {
//
//		titleInput.sendKeys(title);
//		descInput.sendKeys(desc);
//
//		saveButton.click();
//	}
//
// }
