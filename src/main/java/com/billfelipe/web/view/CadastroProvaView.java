package com.billfelipe.web.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.billfelipe.glasgow.framework.View;
import com.billfelipe.glasgow.model.Prova;
import com.billfelipe.service.ProvaService;

@Model
public class CadastroProvaView extends View {

	@Inject
	private ProvaService provaService;

	private Prova prova;

	@PostConstruct
	public void init() {
		this.prova = new Prova();
	}

	@Produces
	@Named
	public Prova getProva() {
		return this.prova;
	}

	@Produces
	@Named(value = "anos")
	public Collection<Integer> getAnos() {
		ArrayList<Integer> anos = new ArrayList<Integer>();
		int anoAtual = LocalDate.now().getYear();
		for (int i = 0; i < 10; i++) {
			anos.add(anoAtual - i);
		}
		return anos;
	}

	public void cadastrar() {
		provaService.cadastrar(prova);
		init();
		pushMessage("Prova cadastrada com sucesso");
	}

}
