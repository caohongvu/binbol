package com.binbol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.binbol.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}
