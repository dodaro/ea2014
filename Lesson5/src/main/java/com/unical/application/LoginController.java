package com.unical.application;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unical.application.dao.UserDao;
import com.unical.application.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController implements ApplicationContextAware{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private ApplicationContext context;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("Welcome to the login page");	
		model.addAttribute("userForm", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String userLogin(
			HttpServletRequest request,
			@ModelAttribute("userForm") User user,
			Model model) {
		logger.info("Login");
		logger.info("Username " + user.getUsername() + " password " + user.getPassword());				
		UserDao userDao = (UserDao) context.getBean("userDAO");		
		//you have to do something smarter!
		User u = userDao.retrieve(user.getUsername());
	    if(u == null)
	    {
	    		//create user
	    		userDao.create(user);	 
	    		logger.info("Creating user " + user.getUsername() + " - " + user.getPassword());
	    		User u1 = userDao.retrieve(user.getUsername());
	    		logger.info("u1 " + u1);
	    		return "redirect:/login";
	    }
	    else if(u.getPassword().equals(user.getPassword()))
	    {
	    		request.getSession().setAttribute("userSession", user.getUsername());
	    		return "redirect:/other";
	    }
	    else
	    {
	    		return "redirect:/login";
	    }
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		context = arg0;		
	}	
}

