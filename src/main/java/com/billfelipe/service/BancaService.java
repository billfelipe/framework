package com.billfelipe.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.billfelipe.glasgow.model.Banca;

@SessionScoped
public class BancaService extends Service<Banca> implements Serializable {

	private List<Banca> bancas;

	@PostConstruct
	public void onEventFired(@Observes(notifyObserver = Reception.ALWAYS) final Banca bancas) {
		this.bancas = null;
	}

	@Named(value = "bancas")
	@Produces
	public Collection<Banca> getAll() {
		if (this.bancas == null) {
			this.bancas = (List<Banca>) dao.getResultList(Banca.class, Banca.GET_ALL);
		}
		return this.bancas;
	}

}
