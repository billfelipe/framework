package com.billfelipe.framework.service;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.billfelipe.framework.dao.GenericDAO;
import com.billfelipe.framework.model.BaseModel;

abstract class BaseService<T extends BaseModel> {

	@Inject
	protected GenericDAO<T> dao;

	@Inject
	protected Event<T> event;

}
