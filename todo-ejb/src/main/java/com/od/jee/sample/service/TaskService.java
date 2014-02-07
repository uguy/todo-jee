package com.od.jee.sample.service;

import java.util.List;

import com.od.jee.sample.model.Task;

public interface TaskService {

	public abstract Task save(Task task);

	public abstract Task findById(Long id);

	public abstract List<Task> findAll();

}