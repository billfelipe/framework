package com.billfelipe.framework.dao;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.billfelipe.framework.model.BaseModel;

abstract class AbstractGenericDAO<T extends BaseModel> implements IGenericDAO<T> {

	@PersistenceContext
	public EntityManager entityManager;

	public T find(Class<T> clazz, long id) {
		return entityManager.find(clazz, id);
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	public T merge(T entity) {
		return entityManager.merge(entity);
	}

	public void remove(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	public Collection<T> getResultList(Class<T> clazz, String queryName, Map<String, Object> parameters) {
		TypedQuery<T> query = entityManager.createNamedQuery(queryName, clazz);
		query = setParameters(query, parameters);
		return query.getResultList();
	}

	public Collection<T> getResultList(Class<T> clazz, String queryName) {
		TypedQuery<T> query = entityManager.createNamedQuery(queryName, clazz);
		return query.getResultList();
	}

	public Object getSingleResult(Class<T> clazz, String queryName) {
		TypedQuery<T> query = entityManager.createNamedQuery(queryName, clazz);
		return query.getSingleResult();
	}

	public Object getSingleResult(Class<T> clazz, String queryName, Map<String, Object> parameters) {
		TypedQuery query = entityManager.createNamedQuery(queryName, clazz);
		query = setParameters(query, parameters);
		return query.getSingleResult();
	}

	private TypedQuery setParameters(TypedQuery query, Map<String, Object> parameters) {
		Set<String> keySet = parameters.keySet();
		for (String key : keySet) {
			query.setParameter(key, parameters.get(key));
		}
		return query;
	}
}
