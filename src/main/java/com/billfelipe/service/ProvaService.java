package com.billfelipe.service;

import javax.enterprise.context.RequestScoped;

import com.billfelipe.glasgow.model.Prova;

@RequestScoped
public class ProvaService extends Service<Prova> {

	public void cadastrar(final Prova prova) {
		dao.merge(prova);
		event.fire(prova);

	}

}
