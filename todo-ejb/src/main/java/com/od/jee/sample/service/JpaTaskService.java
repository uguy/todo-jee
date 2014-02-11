package com.od.jee.sample.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.od.jee.sample.dto.Task;
import com.od.jee.sample.model.TaskEntity;

@Stateless
public class JpaTaskService implements Serializable, TaskService {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "memberUnit")
	private EntityManager em;

	private final Mapper mapper = new DozerBeanMapper();

	@Override
	public Task save(Task task) {
		TaskEntity entity = mapper.map(task, TaskEntity.class);
		em.persist(entity);
		task.setId(entity.getId());
		return task;
	}

	@Override
	public Task findById(Long id) {
		TaskEntity entity = em.find(TaskEntity.class, id);
		return mapper.map(entity, Task.class);
	}

	@Override
	public List<Task> findAll() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TaskEntity> criteria = cb.createQuery(TaskEntity.class);
		Root<TaskEntity> taskEntity = criteria.from(TaskEntity.class);
		criteria.select(taskEntity).orderBy(cb.asc(taskEntity.get("title")));
		List<TaskEntity> result = em.createQuery(criteria).getResultList();

		List<Task> tasks = new ArrayList<Task>();
		for (TaskEntity entity : result) {
			tasks.add(mapper.map(entity, Task.class));
		}

		return tasks;
	}
}
