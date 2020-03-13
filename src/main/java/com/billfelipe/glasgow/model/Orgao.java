package com.billfelipe.glasgow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.billfelipe.glasgow.framework.BaseEntity;

@NamedQuery(name = Orgao.GET_ALL, query = "select o from Orgao o order by o.nome asc")
@Entity
@Table(name = "TB_ORGAO")
public class Orgao extends BaseEntity {

	public static final String GET_ALL = "Orgao.GET_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ORGAO")
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
