package com.dino.dino.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dino.dino.model.*;
import com.dino.dino.repository.*;

@Service
public class ProductService {
	@Autowired
	private ProductRepo proRepo;

	public List<Product> listAll() {

		return proRepo.findAll();
	}

	public void save(Product product) {
		proRepo.save(product);
	}

	public Product get(Long id) {
		return proRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		proRepo.deleteById(id);
	}
	


}
