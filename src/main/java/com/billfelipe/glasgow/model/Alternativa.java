package com.billfelipe.glasgow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.billfelipe.glasgow.framework.BaseEntity;

@Entity
@Table(name = "TB_ALTERNATIVA")
public class Alternativa extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ALTERNATIVA")
	private Long id;

	@Column(name = "DS_CONTEUDO" , length = 5000)
	private String conteudo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_QUESTAO")
	private Questao questao;

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
