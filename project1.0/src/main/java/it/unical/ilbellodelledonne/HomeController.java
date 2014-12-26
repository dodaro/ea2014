package it.unical.ilbellodelledonne;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	/*
	 * è il controller della home, ha il compito di mappare il load, effettuato con jquery
	 * per le due parti statiche home, e chisiamo.
	 */
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value="/homeContent", method=RequestMethod.GET)
	public String homeContent(){
		return "homeContent";
	}
	

	@RequestMapping(value="/chiSiamoContent", method=RequestMethod.GET)
	public String chiSiamo(){
		return "chiSiamoContent";
	}
	
}
