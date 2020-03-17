package com.billfelipe.glasgow.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.billfelipe.glasgow.framework.BaseEntity;

@NamedQueries({
		@NamedQuery(name = Prova.GET_PROVAS_PROCESSADAS, query = "select p from Prova p left join fetch p.cargo left join fetch p.banca left join fetch p.orgao where p.tipoEstadoProva = com.billfelipe.glasgow.model.TipoEstadoProva.PROCESSADA"),
		@NamedQuery(name = Prova.GET_PROVAS_CADASTRADAS, query = "select p from Prova p left join fetch p.documento where p.tipoEstadoProva = com.billfelipe.glasgow.model.TipoEstadoProva.CADASTRADA") })

@Entity
@Table(name = "TB_PROVA")
public class Prova extends BaseEntity {

	public static final String GET_PROVAS_CADASTRADAS = "Prova.GET_PROVAS_CADASTRADA";

	public static final String GET_PROVAS_PROCESSADAS = "Prova.GET_PROVAS_PROCESSADAS";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROVA")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_ORGAO")
	@NotNull(message = "O Órgão não pode ser nulo")
	private Orgao orgao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_BANCA")
	@NotNull(message = "A Banca não pode ser nulo")
	private Banca banca;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_CARGO")
	@NotNull(message = "O Cargo não pode ser nulo")
	private Cargo cargo;

	@Column(name = "NR_ANO")
	@NotNull(message = "O Ano não pode ser nulo")
	private Integer ano;

	@Column(name = "DS_PADRAO_CABECALHO_QUESTAO")
	private String padraoCabecalhoQuestao;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "prova", cascade = CascadeType.ALL)
	@JoinColumn(name = "CD_DOCUMENTO")
	private Documento documento;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prova", orphanRemoval = true, cascade = CascadeType.ALL)
	private Collection<Questao> questoes;

	@Column(name = "TP_PROCESSADA")
	@Enumerated(EnumType.STRING)
	private TipoEstadoProva tipoEstadoProva;

	public Collection<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Collection<Questao> questoes) {
		this.questoes = questoes;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void addQuestao(Questao questao) {
		this.questoes.add(questao);
		questao.setProva(this);
	}

	public void remove(Questao questao) {
		this.questoes.remove(questao);
		questao.setProva(null);
	}

	public void setDocumento(Documento documento) {
		if (documento == null) {
			if (this.documento != null) {
				this.documento.setProva(null);
			}
		} else {
			documento.setProva(this);
		}
		this.documento = documento;
	}

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public Banca getBanca() {
		return banca;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEstadoProva getTipoEstadoProva() {
		return tipoEstadoProva;
	}

	public void setTipoEstadoProva(TipoEstadoProva tipoEstadoProva) {
		this.tipoEstadoProva = tipoEstadoProva;
	}

	public String getPadraoCabecalhoQuestao() {
		return padraoCabecalhoQuestao;
	}

	public void setPadraoCabecalhoQuestao(String padraoCabecalhoQuestao) {
		this.padraoCabecalhoQuestao = padraoCabecalhoQuestao;
	}

}
