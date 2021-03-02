package com.dino.dino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dino.dino.model.Images;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo  extends JpaRepository<Images, Integer>{

}