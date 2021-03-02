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
	@Autowired
	private ImageRepo imageRepo;

	public Images saveImages(Images image) {
		return imageRepo.save(image);
	}

	public List<Product> listAll() {

		return proRepo.findAll();
	}
	public List<Product> findAllSuits() {

		return proRepo.findAllSuits();
	}
	
	public List<Product> findAllCombo() {

		return proRepo.findAllCombo();
	}
	
	
	public List<Product> findAllSkirts() {

		return proRepo.findAllSkirts();
	}
	
	public List<Product> findAllTops() {

		return proRepo.findAllTops();
	}
	
	public List<Product> findAllDress() {

		return proRepo.findAllDress();
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
