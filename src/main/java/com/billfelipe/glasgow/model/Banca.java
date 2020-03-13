package com.billfelipe.glasgow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.billfelipe.glasgow.framework.BaseEntity;

@NamedQuery(name = Banca.GET_ALL, query = "select b from Banca b order by b.nome asc")
@Entity
@Table(name = "TB_BANCA")
public class Banca extends BaseEntity {

	public static final String GET_ALL = "Banca.GET_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BANCA")
	private Long id;

	@Column(name = "DS_NOME")
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}