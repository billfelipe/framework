package com.billfelipe.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.billfelipe.glasgow.model.Prova;

@ApplicationScoped
public class ProvaService extends Service<Prova> implements Serializable {

	private List<Prova> provasProcessadas;
	private List<Prova> provasNaoProcessadas;

	@PostConstruct
	public void onEventFired(@Observes(notifyObserver = Reception.ALWAYS) final Prova prova) {
		this.provasProcessadas = null;
		this.provasNaoProcessadas = null;
	}

	public Collection<Prova> getProvasCadastradas() {
		if (this.provasNaoProcessadas == null) {
			this.provasNaoProcessadas = (List<Prova>) dao.getResultList(Prova.class, Prova.GET_PROVAS_CADASTRADAS);
		}
		return this.provasNaoProcessadas;
	}

	@Named(value = "provasProcessadas")
	@Produces
	public Collection<Prova> getProvasProcessadas() {
		if (this.provasProcessadas == null) {
			this.provasProcessadas = (List<Prova>) dao.getResultList(Prova.class, Prova.GET_PROVAS_PROCESSADAS);
		}
		return this.provasProcessadas;
	}

	public void cadastrar(final Prova prova) {
		dao.merge(prova);
		event.fire(prova);

	}

}
