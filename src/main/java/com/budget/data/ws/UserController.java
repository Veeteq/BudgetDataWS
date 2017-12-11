package com.budget.data.ws;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.budget.data.model.User;
import com.budget.data.service.UserService;

@Controller
@RequestMapping(value="/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(params="new")
	public String createForm(Model model){
		logger.info("starting newUser() method");

		model.addAttribute("user", new User());
		return "users/new";
	}
	
	@RequestMapping(params="display")
	public String showUsers(Model model){
		logger.info("starting showUsers() method");
		
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		
		return "users/display";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveUser(@ModelAttribute(name="user") @Valid User user, BindingResult bindingResult){
		logger.info("starting saveUser() method");
		logger.info("" + user.getName().length());
		
		if(bindingResult.hasErrors()){
			logger.info("bindingResult has detected errors in saveUser() method");
			return "users/edit";
		}
		userService.save(user);
		return "redirect:users?display";
	}

	@RequestMapping(value="{userId}/edit", method=RequestMethod.GET)
	public String editUser(@PathVariable String userId, Map<String, Object> model){
		
		User user = userService.getById(Long.valueOf(userId));
		model.put("user", user);
		return "users/edit";
	}
	
	@RequestMapping(value="{userId}", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute(name="user") @Valid User user, BindingResult bindingResult){
		logger.info("starting updateUser() method");
		
		if(bindingResult.hasErrors()){
			logger.info("bindingResult has detected errors in updateUser() method");
			return "users/edit";
		}
		userService.update(user);
		return "redirect:/users?display";
	}
	
	@RequestMapping(params="items")
	public String showItems(Model model){
		logger.info("starting showItems() method");
		
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		
		return "items/display";
	}

}
