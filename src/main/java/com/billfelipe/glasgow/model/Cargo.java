package com.billfelipe.glasgow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.billfelipe.glasgow.framework.BaseEntity;

@NamedQuery(name = Cargo.GET_ALL, query = "select c from Cargo c order by c.nome asc")
@Entity
@Table(name = "TB_CARGO")
public class Cargo extends BaseEntity {

	public static final String GET_ALL = "Cargo.GET_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CARGO")
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
