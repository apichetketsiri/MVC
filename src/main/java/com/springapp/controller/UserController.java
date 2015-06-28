package com.springapp.controller;

import model.UserDAO;
import model.Users;
import org.apache.log4j.Logger;
import org.hsqldb.rights.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserDAO userDAO;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new Users());

		return "hello";
	}

	@RequestMapping(value ="/", method = RequestMethod.POST)
	@ResponseBody
	public Users submitUser(@ModelAttribute("user") Users user, Model model){
		userDAO.insertUser(user);
		return user;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}