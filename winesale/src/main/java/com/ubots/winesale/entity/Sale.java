package com.ubots.winesale.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@Column(name = "code")
	private String codigo;
	
	@Column(name = "date")
	private LocalDate data;
	
	@Column(name = "client")
	private String client;
	
	@Transient
	private List<Wine> itens;
	
}
