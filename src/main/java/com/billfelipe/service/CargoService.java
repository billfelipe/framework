package com.billfelipe.service;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.billfelipe.glasgow.model.Cargo;

@RequestScoped
public class CargoService extends Service<Cargo> {

	@Named(value = "cargos")
	@Produces
	public Collection<Cargo> getAll() {
		return dao.getResultList(Cargo.class, Cargo.GET_ALL);
	}

}
