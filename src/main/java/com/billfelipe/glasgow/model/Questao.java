package com.billfelipe.glasgow.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.billfelipe.glasgow.framework.BaseEntity;

@NamedQuery(name = Questao.FIND_BY_PROVA, query = "select q from Questao q left join fetch q.alternativas where q.prova = :prova")
@Entity
@Table(name = "TB_QUESTAO")
public class Questao extends BaseEntity {

	public static final String FIND_BY_PROVA = "Prova.GET_QUESTOES_PROVAS_NAO_CONFERIDAS";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_QUESTAO")
	private Long id;

	@Column(name = "DS_CONTEUDO", length = 4000)
	private String conteudo;

	@Column(name = "DS_ENUNCIADO", length = 5000)
	private String enunciado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questao", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Alternativa> alternativas;

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_PROVA")
	private Prova prova;

	public void addAlternativa(Alternativa alternativa) {
		this.alternativas.add(alternativa);
		alternativa.setQuestao(this);
	}

	public void removeAlternativa(Alternativa alternativa) {
		this.alternativas.remove(alternativa);
		alternativa.setQuestao(null);
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

}
