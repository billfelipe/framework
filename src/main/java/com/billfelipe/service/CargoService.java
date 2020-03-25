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

import com.billfelipe.glasgow.model.Cargo;

@SessionScoped
public class CargoService extends Service<Cargo> implements Serializable {

	private List<Cargo> cargos;

	@PostConstruct
	public void onEventFired(@Observes(notifyObserver = Reception.ALWAYS) final Cargo cargo) {
		this.cargos = null;
	}

	@Named(value = "cargos")
	@Produces
	public Collection<Cargo> getAll() {
		if (this.cargos == null) {
			this.cargos = (List<Cargo>) dao.getResultList(Cargo.class, Cargo.GET_ALL);
		}
		return this.cargos;
	}

	public void cadastrar(final Cargo cargo) {
		dao.merge(cargo);
		event.fire(cargo);
	}

	public void remover(Cargo cargo) {
		dao.remove(cargo);
		event.fire(cargo);
	}

}
