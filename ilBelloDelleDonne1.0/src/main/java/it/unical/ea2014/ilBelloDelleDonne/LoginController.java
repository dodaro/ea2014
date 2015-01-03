package it.unical.ea2014.ilBelloDelleDonne;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController implements ApplicationContextAware{
	
	private ApplicationContext context;
	@RequestMapping(value="/loginContent", method=RequestMethod.GET)
	public String login(){
		System.out.println("SONON NEL CONTROLLER LOGIN");
		return "loginContent";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		context = applicationContext;
		
	}
}
