package com.billfelipe.service;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.billfelipe.dao.GenericDAO;
import com.billfelipe.model.entity.BaseEntity;

abstract class Service<T extends BaseEntity> {

	@Inject
	protected GenericDAO<T> dao;
	

	@Inject
	protected Logger log;

}
