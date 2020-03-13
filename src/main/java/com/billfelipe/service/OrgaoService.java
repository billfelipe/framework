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

import com.billfelipe.glasgow.model.Orgao;

@SessionScoped
public class OrgaoService extends Service<Orgao> implements Serializable {

	private List<Orgao> orgaos;

	@PostConstruct
	public void onEventFired(@Observes(notifyObserver = Reception.ALWAYS) final Orgao orgao) {
		this.orgaos = null;
	}

	@Produces
	@Named(value = "orgaos")
	public Collection<Orgao> getOrgaos() {
		if (this.orgaos == null) {
			this.orgaos = (List<Orgao>) dao.getResultList(Orgao.class, Orgao.GET_ALL);
		}
		return this.orgaos;
	}

}
