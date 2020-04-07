package com.ubots.winesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubots.winesale.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
