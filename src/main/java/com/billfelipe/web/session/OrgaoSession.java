package com.billfelipe.web.session;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Inject;

import com.billfelipe.glasgow.model.Orgao;
import com.billfelipe.service.OrgaoService;

@SessionScoped
public class OrgaoSession implements Serializable{

	@Inject
	private OrgaoService orgaoService;

	private List<Orgao> orgaos;

	@PostConstruct
	public void onEventFired(@Observes(notifyObserver = Reception.ALWAYS) final Orgao orgao) {
		orgaos = (List<Orgao>) orgaoService.getAll();
	}

	public List<Orgao> getOrgaos() {
		return orgaos;
	}

	public void setOrgaos(List<Orgao> orgaos) {
		this.orgaos = orgaos;
	}

}
