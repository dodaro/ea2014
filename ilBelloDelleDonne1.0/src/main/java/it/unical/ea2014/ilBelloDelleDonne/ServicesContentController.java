package it.unical.ea2014.ilBelloDelleDonne;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServicesContentController {
	
		@RequestMapping(value="/servicesContent",method=RequestMethod.GET)
		public String services(){
			
			return "servicesContent";
		}
}
