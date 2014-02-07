package com.od.jee.sample.todo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Random;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class HomePageTest {

	@Deployment(name = "todo-ear", testable = false, order = 0)
	public static EnterpriseArchive createEarDeployment() {

		EnterpriseArchive ear = Maven.resolver().loadPomFromFile("pom.xml")
				.resolve("com.od.jee.sample:todo-ear-all:ear:?")
				.withoutTransitivity().asSingle(EnterpriseArchive.class);

		return ear;
	}

	@Drone
	private WebDriver driver;

	@ArquillianResource
	private URL deploymentUrl;

	@Page
	private HomePage homePage;

	private final Random random = new Random();

	@Test
	@RunAsClient
	public void homePageTitleShouldBeTodo() {

		// Browse home page
		driver.get(deploymentUrl.toExternalForm() + "/todo");
		assertEquals("Todo", homePage.getTitle());

	}

	@Test
	@RunAsClient
	public void newTaskShouldBeAddedToTable() {

		// Browse home page
		driver.get(deploymentUrl.toExternalForm() + "/todo");

		// Add new task
		String title = "Hello-" + random.nextInt();
		homePage.getTaskForm().newTask(title, "From arquillian :) ");
		String taskList = homePage.getTaskListText();
		assertTrue(taskList.contains(title));

	}

}
