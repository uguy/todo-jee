package com.od.jee.sample.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.od.jee.sample.model.Task;

@Named
@Stateless
public class JpaTaskService implements Serializable, TaskService {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "memberUnit")
	private EntityManager em;

	@Override
	public Task save(Task task){
		em.persist(task);
		return task;
	}
	
	@Override
	public Task findById(Long id) {
		return em.find(Task.class, id);
	}

	@Override
	public List<Task> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Task> criteria = cb.createQuery(Task.class);
		Root<Task> task = criteria.from(Task.class);
		criteria.select(task).orderBy(cb.asc(task.get("title")));
		return em.createQuery(criteria).getResultList();
	}
}
