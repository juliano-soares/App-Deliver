package com.julianosoares.jls_deliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianosoares.jls_deliver.dto.OrderDTO;
import com.julianosoares.jls_deliver.dto.ProductDTO;
import com.julianosoares.jls_deliver.entities.Order;
import com.julianosoares.jls_deliver.entities.OrderStatus;
import com.julianosoares.jls_deliver.entities.Product;
import com.julianosoares.jls_deliver.repositories.OrderRepository;
import com.julianosoares.jls_deliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrderWithProducts();
		
		return list.stream().map(X -> new OrderDTO(X)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto){
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
				Instant.now(), OrderStatus.PENDING);
		
		for(ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order = repository.save(order);
		return new OrderDTO(order);
	}
}
