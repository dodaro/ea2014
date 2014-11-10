package com.unical.application;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OtherController {
	
	private static final Logger logger = LoggerFactory.getLogger(OtherController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/other", method = RequestMethod.GET)
	public String other(
		HttpServletRequest request,
		Model model) {
		logger.info("Welcome home! My NAME");
				
		String myName = "Carmine";		
		model.addAttribute("MyName", myName );		
		
		String user = (String) request.getSession().getAttribute("userSession");
		if( user == null )
			return "redirect:login";
		model.addAttribute("user", user);
		return "other";
	}
	
}
