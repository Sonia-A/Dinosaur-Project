package com.dino.dino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dino.dino.model.*;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
	@Query("select c from Product c where c.filter ='Suits'")
	List<Product> findAllSuits();
	
	@Query("select c from Product c where c.filter ='Combo'")
	List<Product> findAllCombo();
	
	@Query("select c from Product c where c.filter ='Skirts'")
	List<Product> findAllSkirts();
	
	@Query("select c from Product c where c.filter ='Tops'")
	List<Product> findAllTops();
	
	@Query("select c from Product c where c.filter ='Dresses'")
	List<Product> findAllDress();

}