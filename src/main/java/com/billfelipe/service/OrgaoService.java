package com.billfelipe.service;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.billfelipe.glasgow.model.Orgao;

@RequestScoped
public class OrgaoService extends Service<Orgao> {

	public void cadastrar(final Orgao orgao) {
		log.info("Órgão cadastrado com sucesso");
		dao.merge(orgao);
	}

	@Produces
	@Named(value = "orgaos")
	public Collection<Orgao> getAll() {
		return dao.getResultList(Orgao.class, Orgao.GET_ALL);
	}

}
