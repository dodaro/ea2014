package it.unical.ilbellodelledonne;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignInController {


	
	@RequestMapping(value="/signIn", method = RequestMethod.GET)
	public String signIn(){		
		return "signIn";
	}
}
