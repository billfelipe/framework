package com.billfelipe.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.billfelipe.glasgow.model.Prova;
import com.billfelipe.glasgow.model.Questao;

@ApplicationScoped
public class QuestaoService extends Service<Questao> implements Serializable {

	private List<Questao> questoes;

	private Prova prova;

	public void setProva(final Prova prova) {
		this.prova = prova;
	}

	@Produces
	@Named
	public Collection<Questao> getQuestoes() throws Exception {
		if (prova == null) {
			throw new Exception("Não foi possível obter as questões");
		}

		Map<String, Object> parametrosQuery = new HashMap<String, Object>();
		parametrosQuery.put("prova", prova);
		this.questoes = (List<Questao>) dao.getResultList(Questao.class, Questao.FIND_BY_PROVA, parametrosQuery);

		return this.questoes;
	}

}
