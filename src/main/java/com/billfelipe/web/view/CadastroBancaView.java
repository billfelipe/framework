package com.billfelipe.web.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.billfelipe.glasgow.framework.View;
import com.billfelipe.glasgow.model.Banca;
import com.billfelipe.service.BancaService;

@Model
public class CadastroBancaView extends View {

	@Inject
	private BancaService bancaService;

	@SessionScoped
	private Banca banca;

	@PostConstruct
	public void init() {
		this.banca = new Banca();
	}

	@Produces
	@Named("banca")
	public Banca getBanca() {
		return this.banca;
	}

	public void cadastrar() {
		try {
			bancaService.cadastrar(banca);
			pushMessage(banca.getNome() + " cadastrada com sucesso");
			init();
		} catch (Exception e) {
			pushMessage(e.getLocalizedMessage());
		}
	}

	public void remover(final Banca banca) {
		try {
			bancaService.remover(banca);
			pushMessage(banca.getNome() + " removida com sucesso");
		} catch (Exception e) {
			pushMessage(e.getLocalizedMessage());
		}
	}

}
