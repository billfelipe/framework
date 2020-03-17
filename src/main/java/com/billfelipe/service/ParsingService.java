package com.billfelipe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.billfelipe.glasgow.model.Alternativa;
import com.billfelipe.glasgow.model.Questao;

public class ParsingService {

	List<Integer> encontrarPosicoesDosCabecalhos(final String conteudo, final String padraoDoCabecalho) {
		Pattern pattern = Pattern.compile(padraoDoCabecalho);
		Matcher matcher = pattern.matcher(conteudo);
		List<Integer> posicoesDosCabecalhos = new ArrayList<Integer>();
		while (matcher.find()) {
			posicoesDosCabecalhos.add(matcher.start());
		}
		return posicoesDosCabecalhos;
	}

	public List<Questao> separarQuestoes(final String conteudo, final String padraoDoCabecalho) {
		List<Integer> posicoesDosCabecalhos = encontrarPosicoesDosCabecalhos(conteudo, padraoDoCabecalho);
		ArrayList<Questao> questoes = new ArrayList<Questao>();
		for (int i = 0; i < posicoesDosCabecalhos.size() - 1; i++) {
			String conteudoQuestao = dividirConteudo(conteudo, posicoesDosCabecalhos.get(i),
					posicoesDosCabecalhos.get(i + 1));
			Questao questao = new Questao();
			questao.setConteudo(conteudoQuestao);
			questoes.add(questao);
		}

		String conteudoUltimaQuestao = dividirConteudo(conteudo,
				posicoesDosCabecalhos.get(posicoesDosCabecalhos.size() - 1));
		Questao ultimaQuestao = new Questao();
		ultimaQuestao.setConteudo(conteudoUltimaQuestao);
		questoes.add(ultimaQuestao);
		return questoes;
	}

	public void separarAlternativas(Questao questao, final String padraoDoCabecalho) {
		List<Integer> posicoesDosCabecalhos = encontrarPosicoesDosCabecalhos(questao.getConteudo(), padraoDoCabecalho);
		questao.setAlternativas(new ArrayList<Alternativa>());

		String enunciado = dividirConteudo(questao.getConteudo(), 0, posicoesDosCabecalhos.get(0));
		questao.setEnunciado(enunciado);
		
		for (int i = 0; i < posicoesDosCabecalhos.size() - 1; i++) {
			String conteudoDividido = dividirConteudo(questao.getConteudo(), posicoesDosCabecalhos.get(i),
					posicoesDosCabecalhos.get(i + 1));
			Alternativa alternativa = new Alternativa();
			alternativa.setConteudo(conteudoDividido);
			questao.addAlternativa(alternativa);
		}

		String conteudoUltimaAlternativa = dividirConteudo(questao.getConteudo(),
				posicoesDosCabecalhos.get(posicoesDosCabecalhos.size() - 1));
		Alternativa ultimaAlternativa = new Alternativa();
		ultimaAlternativa.setConteudo(conteudoUltimaAlternativa);
		questao.addAlternativa(ultimaAlternativa);
	}

	public String dividirConteudo(String conteudo, int posiciaoInicial) {
		return conteudo.substring(posiciaoInicial);
	}

	public String dividirConteudo(String conteudo, int posiciaoInicial, int posicaoFinal) {
		return conteudo.substring(posiciaoInicial, posicaoFinal);
	}

}
