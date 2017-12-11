package com.budget.data.ws;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budget.data.model.Category;
import com.budget.data.service.CategoryService;

@Controller
@RequestMapping(value="/categories")
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(params="display")
	public String showCategories(Model model){
		logger.info("starting showCategories() method");
		
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		
		return "categories/display";
	}
}
