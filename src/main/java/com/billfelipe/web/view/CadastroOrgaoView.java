package com.billfelipe.web.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.billfelipe.glasgow.framework.View;
import com.billfelipe.glasgow.model.Orgao;
import com.billfelipe.service.OrgaoService;

@Model
public class CadastroOrgaoView extends View {

	@Inject
	private OrgaoService orgaoService;

	@SessionScoped
	private Orgao orgao;

	@PostConstruct
	public void init() {
		this.orgao = new Orgao();
	}

	@Produces
	@Named("orgao")
	public Orgao getOrgao() {
		return this.orgao;
	}

	public void cadastrar() {
		try {
			orgaoService.cadastrar(orgao);
			pushMessage(orgao.getNome() + " cadastrado com sucesso");
			init();
		} catch (Exception e) {
			pushMessage(e.getLocalizedMessage());
		}
	}

	public void remover(final Orgao orgao) {
		try {
			orgaoService.remover(orgao);
			pushMessage(orgao.getNome() + " removido com sucesso");
		} catch (Exception e) {
			pushMessage(e.getLocalizedMessage());
		}
	}

}
