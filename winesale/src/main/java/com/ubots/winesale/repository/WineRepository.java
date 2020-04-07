package com.ubots.winesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubots.winesale.entity.Wine;

public interface WineRepository extends JpaRepository<Wine, Integer> {

}
