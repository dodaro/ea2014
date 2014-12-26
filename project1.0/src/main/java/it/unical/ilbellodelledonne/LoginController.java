package it.unical.ilbellodelledonne;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/loginContent", method=RequestMethod.GET)
	public String login(){
		System.out.println("SONON NEL CONTROLLER LOGIN");
		return "loginContent";
	}
}
