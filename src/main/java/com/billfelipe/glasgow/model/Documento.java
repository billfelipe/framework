package com.billfelipe.glasgow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.billfelipe.glasgow.framework.BaseEntity;

@NamedQuery(name = Documento.GET_ALL_SEM_CADASTRO, query = "select d from Documento d where d.prova is null")
@Entity
@Table(name = "TB_DOCUMENTO")
public class Documento extends BaseEntity {

	public static final String GET_ALL_SEM_CADASTRO = "Documento.GET_ALL_SEM_CADASTRO";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DOCUMENTO")
	private Long id;

	@Column(name = "BT_ARQUIVO")
	@Lob
	private byte[] arquivo;

	@Column(name = "DS_NOME")
	private String nome;

	@Column(name = "DS_CONTENT_TYPE")
	private String contentType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_IMPORTACAO")
	private Date dataImportacao = new Date(System.currentTimeMillis());

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_PROVA")
	private Prova prova;

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

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getDataImportacao() {
		return dataImportacao;
	}

	public void setDataImportacao(Date dataImportacao) {
		this.dataImportacao = dataImportacao;
	}

}
