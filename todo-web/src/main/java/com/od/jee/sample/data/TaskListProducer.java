package com.od.jee.sample.data;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.od.jee.sample.model.Task;
import com.od.jee.sample.service.TaskService;

@RequestScoped
public class TaskListProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TaskService taskRepository;

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
		tasks = taskRepository.findAll();
	}

}
