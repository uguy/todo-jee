package com.od.jee.sample.todo;

import static org.junit.Assert.assertEquals;

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
				.resolve("com.od.jee.sample:todo-ear:ear:?")
				.withoutTransitivity().asSingle(EnterpriseArchive.class);
		return ear;
	}

	// @Deployment(name = "todo-web", testable = false, order = 1)
	// public static WebArchive createWarDeployment() {
	// WebArchive war = Maven.resolver().loadPomFromFile("pom.xml")
	// .resolve("com.od.jee.sample:todo-web:war:?")
	// .withoutTransitivity().asSingle(WebArchive.class);
	// return war;
	// }

	@Drone
	private WebDriver browser;

	@ArquillianResource
	private URL deploymentUrl;

	@Page
	private HomePage homePage;

	private final Random random = new Random();

	@RunAsClient
	@Test
	public void homePageTitleShouldBeTodo() {

		browser.get(deploymentUrl.toExternalForm() + "/todo");

		assertEquals("Todo", homePage.getTitle());

	}
}
