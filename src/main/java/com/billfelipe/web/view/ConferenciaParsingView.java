package com.billfelipe.web.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.billfelipe.glasgow.model.Prova;
import com.billfelipe.service.QuestaoService;

@Model
public class ConferenciaParsingView {

	@Inject
	private QuestaoService questaoService;
	
	public String conferirProva(final Prova prova) {
		questaoService.setProva(prova);
		return "conferir.xhtml?faces-redirect=true";
	}
	
}
