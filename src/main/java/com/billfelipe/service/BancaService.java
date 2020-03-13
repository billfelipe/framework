package com.billfelipe.service;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.billfelipe.glasgow.model.Banca;

@RequestScoped
public class BancaService extends Service<Banca> {

	@Named(value = "bancas")
	@Produces
	public Collection<Banca> getAll() {
		return dao.getResultList(Banca.class, Banca.GET_ALL);
	}

}
