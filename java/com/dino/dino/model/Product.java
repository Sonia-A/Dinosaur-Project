package com.dino.dino.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String brand;
	private Double price;
	@Transient
	private List<MultipartFile> image;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Images> imageName;
	@Transient
	private List<Product> cartItem;
	@Enumerated(EnumType.STRING)
	private Filter filter;

	public List<Product> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<Product> cartItem) {
		this.cartItem = cartItem;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}

	public List<Images> getImageName() {
		return imageName;
	}

	public void setImageName(List<Images> imageName) {
		this.imageName = imageName;
	}

	public List<MultipartFile> getImage() {
		return image;
	}

	public void setImage(List<MultipartFile> image) {
		this.image = image;
	}

	
	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", image=" + image
				+ ", imageName=" + imageName + ", cartItem=" + cartItem + ", filter=" + filter + "]";
	}


	
    
}