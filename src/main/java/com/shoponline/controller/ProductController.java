package com.shoponline.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shoponline.entities.Product;
import com.shoponline.service.impl.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	
	
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		
		if(cid.isPresent()) {
			List<Product> list = productService.findByCategoryId(cid.get());
			model.addAttribute("items", list);
			return "product/list";
		}else {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
			return paginated(1, model); 
		}
		
	}
	
	@RequestMapping("/product/detail/{id}")
    public String productDetail(Model model, @PathVariable("id") Integer id){
		Product item = productService.findById(id);
		model.addAttribute("item", item);
        return "product/detail";
    }
	
	@RequestMapping("/product/list/page/{pageNo}")
	public String paginated(@PathVariable("pageNo") Integer pageNo, Model model) {
		Integer pageSize = 6;
		
		Page<Product> page = productService.findPaginated(pageNo, pageSize);
		List<Product> listProducts = page.getContent();
		
//		if(pageNo == 0) { 
//			model.addAttribute("currentPage", 2);
//		}else {
//			model.addAttribute("currentPage", pageNo);
//		}
//		
//		if(pageNo > page.getTotalPages()) {
//			model.addAttribute("currentPage", 0);
//		}else {
//			model.addAttribute("currentPage", pageNo);
//		}
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("items", listProducts);
		
		return "product/list";
		
	}
	
	
	@GetMapping("/product")
	public String search(Model model, @RequestParam(required = false, name="search") String search) {
		List<Product> list = productService.findByNameProduct(search);
		model.addAttribute("items", list);
		
		return "product/list";
		 
	}
}
