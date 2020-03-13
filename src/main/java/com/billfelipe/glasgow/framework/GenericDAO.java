package com.billfelipe.glasgow.framework;

import javax.ejb.Stateless;

@Stateless
public class GenericDAO<T extends BaseEntity> extends AbstractGenericDAO<T> {

}
