package io.github.jesusmoh.zinventory.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jesusmoh.zinventory.persistence.entities.Inventory;

public interface IInventoryRespository extends JpaRepository<Inventory, Integer> {

}