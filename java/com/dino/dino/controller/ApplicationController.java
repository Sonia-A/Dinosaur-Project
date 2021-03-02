package com.dino.dino.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dino.dino.model.*;
import com.dino.dino.service.*;


@Controller
@Component
public class ApplicationController {
	private final String UPLOAD_DIR = "C:\\Users\\seth.abayo.GTBank\\Desktop\\Dino\\src\\main\\resources\\static\\images\\";

	@Autowired
	private ProductService service;
	
	@Autowired
	private ShoppingCart shopi;

	@Autowired
	private ControllerFunction controllerFunction;
	
	List<Product> p = new ArrayList<>();
    Double pro = 0.0;
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
	public String saveProduct(HttpServletRequest servletRequest,@ModelAttribute("pro") Product pro ) {

         String fileName = "";
        // save the file on the local file system
		List<MultipartFile> files = pro.getImage();
		List<Images> image = new ArrayList<>();
        List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

			     fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				Images img = new Images();
				img.setName(fileName);
				img.setProduct(pro);
				image.add(img);
				System.out.println("meme1");
//				File imageFile = new File(servletRequest.getServletContext().getRealPath("/static/images"), fileName);
				Path path = Paths.get(UPLOAD_DIR + fileName);
				try {
//					multipartFile.transferTo(imageFile);
					Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
			//	Path path = Paths.get(UPLOAD_DIR + fileName);
			//	Files.copy(pro.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				pro.setImageName(image);
				System.out.println("meme2");
				service.save(pro);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		String fil = "";
		model.addAttribute("product", product);
		model.addAttribute("fil",fil);
		return "shopping_cart"; 
	}
  
	@RequestMapping(value="/filter") 
	public String shoppingFilter(@RequestParam(value="name") String name,Model model) {
		List<Product> product = service.listAll();
		model.addAttribute("product", product);
		System.out.println(name);
		return "shopping_cart";
	}
	
	
	
	@RequestMapping("/suits")
	public String viewSuits(Model model) {
		List<Product> product = service.findAllSuits();
		model.addAttribute("product", product);
		return "shopping_cart";
	}
	
	@RequestMapping("/combo")
	public String viewCombo(Model model) {
		List<Product> product = service.findAllCombo();
		model.addAttribute("product", product);
		return "shopping_cart";
	}
	
	@RequestMapping("/tops")
	public String viewTops(Model model) {
		List<Product> product = service.findAllTops();
		model.addAttribute("product", product);
		return "shopping_cart";
	}
	
	@RequestMapping("/dress")
	public String viewDress(Model model) {
		List<Product> product = service.findAllDress();
		model.addAttribute("product", product);
		return "shopping_cart";
	}
	
	@RequestMapping("/skirts")
	public String viewSkirts(Model model) {
		List<Product> product = service.findAllSkirts();
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
	        pro = 0.0;
			p.add(service.get(id));
			System.out.println(id);
			shopi.setCartItem(p);
			for(Product i:p) {
				pro = pro+i.getPrice();
			}
			shopi.setTot(pro);
			System.out.println(pro);
			model.addAttribute("product", shopi.getCartItem());
			model.addAttribute("totalPrice",pro);
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
	@RequestMapping("/product/{itemId}")
	public String ymem(Model model,@PathVariable("itemId") Long id) {
		model.addAttribute("pro", service.get(id));
		return "product";
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
