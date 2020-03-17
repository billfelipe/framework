package com.billfelipe.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.billfelipe.glasgow.model.Prova;
import com.billfelipe.glasgow.model.Questao;

@ApplicationScoped
public class ProvaService extends Service<Prova> implements Serializable {

	@Inject
	private PDFService pdfService;

	@Inject
	private ParsingService parsingServico;

	public void cadastrar(Prova prova) throws IOException {
		String conteudoDoArquivo = pdfService.extrairConteudoDoArquivo(prova);
		List<Questao> questoes = parsingServico.separarQuestoes(conteudoDoArquivo, prova.getPadraoCabecalhoQuestao());
		for (Questao questao : questoes) {
			parsingServico.separarAlternativas(questao, prova.getPadraoCabecalhoAlternativa());
			prova.addQuestao(questao);
		}
		dao.merge(prova);
	}

	@Named("provasNaoConferidas")
	@Produces
	public Collection<Prova> getProvasNaoConferidas() {
		return dao.getResultList(Prova.class, Prova.GET_PROVAS_NAO_CONFERIDAS);
	}

}
