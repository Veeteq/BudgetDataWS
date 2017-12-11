package com.budget.data.ws;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.budget.data.model.User;
import com.budget.data.service.UserService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home(Locale locale){
		logger.info("Welcome home. The client locale is: " + locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		return new ModelAndView("home", "serverTime", formattedDate);
	}
	
	@ModelAttribute(name="users")
	public List<User> getAllUsers(){
		logger.info("calling getAllUsers() method.");
		return userService.getAll();
	}
}
