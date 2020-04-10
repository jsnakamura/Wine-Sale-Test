package com.ubots.winesale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wines")
public class Wine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "product")
	private String produto;

	@Column(name = "variety")
	private String variedade;

	@Column(name = "country")
	private String pais;

	@Column(name = "category")
	private String categoria;

	@Column(name = "harvest")
	private String safra;

	@Column(name = "price")
	private double preco;
}
