package com.dino.dino.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dino.dino.model.*;
import com.dino.dino.service.*;


@Controller
@Component
public class ApplicationController {
	private final String UPLOAD_DIR = "/home/sonia/Documents/dinos/src/main/resources/static/images/";
	@Autowired
	private ProductService service;
	
	@Autowired
	private ShoppingCart shopi;

	@Autowired
	private ControllerFunction controllerFunction;

	@RequestMapping("/productManagement")
	public String viewHomePage(Model model) {
		List<Product> product = service.listAll();
		model.addAttribute("product", product);
		return "product_index";
	}

	@RequestMapping("/new")
	public String newProduct(Model model) {
		Product pro = new Product();
		model.addAttribute("pro", pro);
		return "new_product";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("pro") Product pro) {
		
		
		String fileName = StringUtils.cleanPath(pro.getFile().getOriginalFilename());

        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(pro.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            pro.setImage(fileName);
            service.save(pro);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return "redirect:/";
		
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEdiProduct(@PathVariable(name="id") Long id) {
		ModelAndView mv = new ModelAndView("edit_product");
		
		Product produ= service.get(id);
		mv.addObject("produ", produ);
		return mv;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") Long id) {
		service.delete(id);
		
		return "redirect:/";
		
		
	}
	@RequestMapping("/shop")
	public String shopping(Model model) {
		List<Product> product = service.listAll();
		model.addAttribute("product", product);
		return "shopping_cart";
	}
	
//	@RequestMapping("/shopping_car")
//	public String shops() {
//		
//		return "shop";
//	}
	@RequestMapping("/shopping_car")
	public String addToCart() {
		
		return "shopping";
	}
	
	@RequestMapping("/faq")
	public String faq() {
		
		return "faq";
	}
	
	@RequestMapping("/shops/{itemId}")
	public String shop(Model model,@PathVariable("itemId") Long id) {	
	
			List<Product> p = new ArrayList<>();
			p.add(service.get(id));
			System.out.println(id);
			shopi.setCartItem(p);
			System.out.println(shopi);
			model.addAttribute("product", shopi.getCartItem());
			return "shopping";
		
	}
	
	@RequestMapping("/about")
	public String about() {
		
		return "about";
	}
	@RequestMapping("shops/yu")
	public String yu() {
		
		return "redirect:/shop";
	}
	
	@RequestMapping("/check")
	public String check(Model model) {
		CustomerDetails customerDetails = new CustomerDetails();
		model.addAttribute("pro",customerDetails);
		return "checkout";
	}
	@RequestMapping(value = "/checking",method=RequestMethod.POST)
	public String executeCheckout(@ModelAttribute("pro") CustomerDetails pro, Model model) throws Exception {
		shopi.setCustomerDetails(pro);
		System.out.println(shopi);
		controllerFunction.sendEmail(shopi);
		return "redirect:/";
	}
	
	@RequestMapping("shops/customer")
	public String check2() {

		return "redirect:/check";
	}
	

	public ShoppingCart getShop() {
		return shopi;
	}

	public void setShop(ShoppingCart shop) {
		this.shopi = shop;
	}
	

	
	
}
