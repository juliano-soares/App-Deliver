package com.julianosoares.jls_deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianosoares.jls_deliver.dto.OrderDTO;
import com.julianosoares.jls_deliver.entities.Order;
import com.julianosoares.jls_deliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrderWithProducts();
		
		return list.stream().map(X -> new OrderDTO(X)).collect(Collectors.toList());
	}
}
