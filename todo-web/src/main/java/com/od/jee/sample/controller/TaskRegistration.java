package com.od.jee.sample.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.od.jee.sample.dto.Task;
import com.od.jee.sample.service.TaskService;

// The @Stateful annotation eliminates the need for manual transaction demarcation
@Stateful
@Model
public class TaskRegistration implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private TaskService taskService;

	@Inject
	private Event<Task> taskEventSrc;

	private Task newTask;

	@Produces
	@Named
	public Task getNewTask() {
		return newTask;
	}

	public void register() throws Exception {
		taskService.save(newTask);
		taskEventSrc.fire(newTask);
		initNewTask();
	}

	@PostConstruct
	public void initNewTask() {
		newTask = new Task();
	}
}
