package com.julianosoares.jls_deliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianosoares.jls_deliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
