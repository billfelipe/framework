package com.billfelipe.dao;

import javax.ejb.Stateless;

import com.billfelipe.model.entity.BaseEntity;

@Stateless
public class GenericDAO<T extends BaseEntity> extends AbstractGenericDAO<T> {

}
