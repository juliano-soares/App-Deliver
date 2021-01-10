package com.julianosoares.jls_deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianosoares.jls_deliver.dto.ProductDTO;
import com.julianosoares.jls_deliver.entities.Product;
import com.julianosoares.jls_deliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAllByOrderByNameAsc();
		
		return list.stream().map(X -> new ProductDTO(X)).collect(Collectors.toList());
	}
}
