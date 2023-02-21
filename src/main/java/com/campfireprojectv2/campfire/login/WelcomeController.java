package com.campfireprojectv2.campfire.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.campfireprojectv2.campfire.user.User;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	
	// pass a usertype here
	// use logic with if statements to render the correct template
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		User user = new User();
		switch(getLoggedinUsername()) {
		case "Will": 
			user = new User(getLoggedinUsername().toString(), "Admin", true);
			return "welcome";
		case "Client":
			user = new User(getLoggedinUsername().toString(), "Client", true);
			return "welcome_client";
		case "Tester":
			user = new User(getLoggedinUsername().toString(), "Tester", true);
			return "welcome_tester";
		case "Developer":
			user = new User(getLoggedinUsername().toString(), "Developer", true);
			return "welcome_developer";
		case "Engineer":
			user = new User(getLoggedinUsername().toString(), "Engineer", true);
			return "welcome_eng";
		default:
			return "welcome";
		}	
	}

	private String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}