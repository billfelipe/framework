package com.billfelipe.framework.dao;

import javax.ejb.Stateless;

import com.billfelipe.framework.model.BaseModel;

@Stateless
public class GenericDAO<T extends BaseModel> extends AbstractGenericDAO<T> {

}
