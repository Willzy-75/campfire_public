package com.campfireprojectv2.campfire.user;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;

@Controller
@SessionAttributes
public class UserControllerJpa {
	
	private UserRepository userRepository;	
	
	// the constructor for the userRepository
	public UserControllerJpa(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@RequestMapping("list-users")
	public String listAllUsers(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<User> users = userRepository.findByUsername(username);
		model.addAttribute("users", users);
		
		return "listUsers";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		
	}
	
	// GET only need separate method for POST
	@RequestMapping(value="add-user", method=RequestMethod.GET)
	public String showNewUserPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		User user = new User(0, username, "Enter Password", "Enter Usertype", "Enter Email", false);
		model.put("user", user);
		return "user";
	}
	
	@RequestMapping(value="add-user", method=RequestMethod.POST)
	public String addNewUserPage(ModelMap model, @Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user";
		}
		
		String username = getLoggedInUsername(model);
		user.setUsername(username);
		userRepository.save(user);
		
		return "redirect:list-users";
	}
	
	@RequestMapping("delete-user")
	public String deleteUser(@RequestParam int id) {
		// delete user redirect to list
		userRepository.deleteById(id);
//		userService.deleteById(id);
		return "redirect:list-users";
	}
	
	@RequestMapping(value="update-user", method = RequestMethod.GET)
	public String showUpdateUserPage(@RequestParam int id, ModelMap model) {
		User user = userRepository.findById(id).get();
		model.addAttribute("user", user);
		return "user";
	}
	
	@RequestMapping(value="update-user", method=RequestMethod.POST)
	public String updateUser(ModelMap model, @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "user";
		}
		String username = getLoggedInUsername(model);
		user.setUsername(username);
		userRepository.save(user);
		return "redirect:list-users";
	}	
	
}
