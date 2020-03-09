package com.billfelipe.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.billfelipe.model.enums.CategoryEnum;

@Entity
@Table(name = "TB_EXAMPLE", schema = "SCH_ARCHETYPE")
public class Example extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EXAMPLE")
	private Long id;

	@Column(name = "DS_NAME")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "TP_CATEGORY")
	private CategoryEnum category;

	@Column(name = "DT_DATE")
	private LocalDate date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
