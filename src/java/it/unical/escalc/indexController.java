package it.unical.escalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexGETMapper(Model model){
		
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String indexPOSTMapper(Model model, 
								  @RequestParam("value1") Integer value1, 
								  @RequestParam("value2") Integer value2, 
								  @RequestParam("op") String operation) {
		switch(operation){
			case "sum":
				model.addAttribute("resultValue", value1 + value2);
				break;
			case "mult":
				model.addAttribute("resultValue", value1 * value2);
				break;
			default:
				model.addAttribute("resultValue", "error");
		}
		return "index";
	}
}
