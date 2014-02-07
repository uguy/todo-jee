package com.od.jee.sample.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.od.jee.sample.model.Task;
import com.od.jee.sample.service.TaskService;

@Path("/tasks")
@RequestScoped
public class TaskResource {

	@Inject
	private TaskService taskService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Task> get() {
		return taskService.findAll();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Task getById(@PathParam("id") long id) {
		return taskService.findById(id);
	}
}
