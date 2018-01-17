package com.budget.data.ws;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.budget.data.model.Expense;
import com.budget.data.service.ExpenseService;
import com.budget.data.service.ItemService;
import com.budget.data.service.UserService;

@Controller
@RequestMapping(value="/expenses")
public class ExpenseController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping(params="new")
	public String createForm(Model model, Locale locale){
		logger.info("starting newExpense() method");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("formattedDate", formattedDate);
		model.addAttribute("expense", new Expense());
		model.addAttribute("items", itemService.getAll());
		model.addAttribute("users", userService.getAll());
		return "expenses/new";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String saveExpense(@ModelAttribute(name="expense") @Valid Expense expense, BindingResult bindingResult){
		logger.info("starting saveExpense() method");
		
		expenseService.save(expense);
		
		logger.info(expense.toString());
		return "redirect:/expenses?new";
	}
}
