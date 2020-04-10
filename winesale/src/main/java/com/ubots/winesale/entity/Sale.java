package com.ubots.winesale.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "code")
	private String codigo;

	@Column(name = "date")
	private String data;

	@Column(name = "client")
	private String cliente;

	@OneToMany(targetEntity = Wine.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "sale_id", referencedColumnName = "id")
	private List<Wine> itens;

	@Column(name = "total_value")
	private double valorTotal;
}
