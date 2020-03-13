package com.billfelipe.glasgow.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.billfelipe.glasgow.framework.BaseEntity;

@Entity
@Table(name = "TB_PROVA")
public class Prova extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROVA")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_ORGAO")
	private Orgao orgao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_BANCA")
	private Banca banca;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_CARGO")
	private Cargo cargo;

	@Column(name = "NR_ANO")
	private Integer ano;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "prova", cascade = CascadeType.ALL)
	@JoinColumn(name = "CD_DOCUMENTO")
	private Documento documento;

	public Documento getDocumento() {
		return documento;
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

}
