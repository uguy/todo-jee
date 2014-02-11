package com.od.jee.sample.data;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.od.jee.sample.dto.Task;
import com.od.jee.sample.service.TaskService;

@RequestScoped
public class TaskListProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private TaskService taskService;

	private List<Task> tasks;

	@Produces
	@Named
	public List<Task> getTasks() {
		return tasks;
	}

	public void onTaskListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Task task) {
		retrieveAllTasksOrderedByTitle();
	}

	@PostConstruct
	public void retrieveAllTasksOrderedByTitle() {
		tasks = taskService.findAll();
	}

}
