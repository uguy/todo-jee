package com.od.jee.sample.todo;

import static com.jayway.restassured.RestAssured.given;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@Ignore
@RunWith(Arquillian.class)
public class HomePageTest {

	@Deployment(name = "todo-ear", order = 0)
	public static EnterpriseArchive createEarDeployment() {
		EnterpriseArchive ear = Maven.resolver().loadPomFromFile("pom.xml")
				.resolve("com.od.jee.sample:todo-ear:ear:?")
				.withoutTransitivity().asSingle(EnterpriseArchive.class);
		return ear;
	}

	@Deployment(name = "todo-web", order = 1)
	public static WebArchive createWarDeployment() {
		WebArchive war = Maven.resolver().loadPomFromFile("pom.xml")
				.resolve("com.od.jee.sample:todo-web:war:?")
				.withoutTransitivity().asSingle(WebArchive.class);
		return war;
	}

	// @Drone
	// private WebDriver browser;
	//
	// @ArquillianResource
	// private URL deploymentUrl;
	//
	// @Page
	// private HomePage homePage;
	//
	// private final Random random = new Random();
	//
	// @RunAsClient
	// @Test
	// public void homePageTitleShouldBeTodo() {
	//
	// browser.get(deploymentUrl.toExternalForm() + "/todo");
	//
	// assertEquals("Todo", homePage.getTitle());
	//
	// }

	@Test
	public void home() throws Exception {
		given().get("http://localhost:8080/todo-web-1.0-SNAPSHOT").then()
				.statusCode(200);
	}

}
