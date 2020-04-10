package com.ubots.winesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubots.winesale.entity.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer> {

}
