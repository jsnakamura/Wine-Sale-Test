package com.ubots.winesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubots.winesale.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
