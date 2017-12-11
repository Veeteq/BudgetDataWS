package com.budget.data.ws;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budget.data.model.Item;
import com.budget.data.service.ItemService;

@Controller
@RequestMapping(value="/items")
public class ItemController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(params="display")
	public String showItems(Model model){
		logger.info("starting showItems() method");
		
		List<Item> items = itemService.getAll();
		model.addAttribute("items", items);
		
		return "items/display";
	}
}
