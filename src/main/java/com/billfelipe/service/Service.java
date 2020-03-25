package com.billfelipe.service;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.billfelipe.glasgow.framework.BaseEntity;
import com.billfelipe.glasgow.framework.GenericDAO;

abstract class Service<T extends BaseEntity> {

	@Inject
	protected GenericDAO<T> dao;

	@Inject
	protected Event<T> event;

}
