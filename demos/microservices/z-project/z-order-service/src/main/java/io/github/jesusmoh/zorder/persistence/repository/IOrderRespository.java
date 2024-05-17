package io.github.jesusmoh.zorder.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jesusmoh.zorder.persistence.entities.Order;

public interface IOrderRespository extends JpaRepository<Order, Integer> {

}