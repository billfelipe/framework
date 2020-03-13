package com.billfelipe.glasgow.framework;

import java.util.Collection;
import java.util.Map;

interface IGenericDAO<T extends BaseEntity> {

	T find(Class<T> clazz, final long id);

	void persist(T entity);

	T merge(T entity);

	void remove(T entity);

	Collection<T> getResultList(Class<T> clazz, String queryName);

	Collection<T> getResultList(Class<T> clazz, String queryName, Map<String, Object> parameters);

	Object getSingleResult(Class<T> clazz, String queryName);

	Object getSingleResult(Class<T> clazz, String queryName, Map<String, Object> parameters);

}
