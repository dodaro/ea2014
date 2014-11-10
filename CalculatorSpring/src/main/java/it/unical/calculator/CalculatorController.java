package it.unical.calculator;

import it.unical.calculator.model.Calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/calculator", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome Calculator!");
		model.addAttribute("calculatorAction", new Calculator() );		
		return "calculator";
	}
	
	@RequestMapping(value="/calculator", method=RequestMethod.POST)
	public String executeOperation(
			@RequestParam String calc,
			@ModelAttribute("calculatorAction") Calculator calculator,
			Model model) {
		logger.info("Execute operation " + calculator.getNumber1() + calc + calculator.getNumber2());		
		if( calc != null && calc.length() == 1)			
			model.addAttribute("result",calculator.execute(calc.charAt(0)));
		return "calculator";
	}	

}
