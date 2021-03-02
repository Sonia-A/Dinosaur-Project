package com.dino.dino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dino.dino.model.*;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
