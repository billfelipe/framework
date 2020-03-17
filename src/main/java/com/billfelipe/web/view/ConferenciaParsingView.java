package com.billfelipe.web.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.billfelipe.glasgow.framework.View;
import com.billfelipe.glasgow.model.Prova;
import com.billfelipe.service.QuestaoService;

@Model
public class ConferenciaParsingView extends View {

	@Inject
	private QuestaoService questaoService;

	public String conferirProva(final Prova prova) {
		questaoService.setProva(prova);
		return "conferir.xhtml?faces-redirect=true";
	}
	
	public void alterarEstadoProva() {
		
	}

}
