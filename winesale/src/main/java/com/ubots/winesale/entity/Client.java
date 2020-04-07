package com.ubots.winesale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client {

	@Id
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	String nome;
	
	@Column(name = "cpf")
	String cpf;
}
