package com.billfelipe.web.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.billfelipe.glasgow.framework.View;
import com.billfelipe.glasgow.model.Orgao;

@RequestScoped
@Named
public class CadastroOrgaoView extends View {

	private Orgao orgao;

	@Inject
	private Event<Orgao> orgaoEventSrc;

	@Produces
	@Named
	public Orgao getOrgao() {
		return this.orgao;
	}

	@PostConstruct
	public void init() {
		this.orgao = new Orgao();
	}

	public void cadastrar() {
		orgaoEventSrc.fire(orgao);
		init();
		pushMessage("Órgão cadastrado com  sucesso");
	}

}
