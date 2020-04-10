package com.ubots.winesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubots.winesale.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
