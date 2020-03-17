package com.billfelipe.service.schedule;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.billfelipe.glasgow.model.Prova;
import com.billfelipe.glasgow.model.Questao;
import com.billfelipe.glasgow.model.TipoEstadoProva;
import com.billfelipe.service.PDFService;
import com.billfelipe.service.ParsingServico;
import com.billfelipe.service.ProvaService;

@Startup
@Singleton
public class ParsingSchedule {

	@Inject
	private ProvaService provaService;

	@Inject
	private PDFService pdfService;

	@Inject
	private ParsingServico parsingServico;

	@Schedule(minute = "*", hour = "*")
	public void run() throws IOException {
		Collection<Prova> provasNaoConferidas = provaService.getProvasCadastradas();
		for (Prova prova : provasNaoConferidas) {
			String conteudoDoArquivo = pdfService.extrairConteudoDoArquivo(prova);
			List<Questao> questoes = parsingServico.separarQuestoes(conteudoDoArquivo,
					prova.getPadraoCabecalhoQuestao());
			for (Questao questao : questoes) {
				prova.addQuestao(questao);
			}
			prova.setTipoEstadoProva(TipoEstadoProva.PROCESSADA);
			provaService.cadastrar(prova);
		}
	}

}
