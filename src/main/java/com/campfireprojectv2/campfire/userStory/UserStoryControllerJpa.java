package com.campfireprojectv2.campfire.userStory;

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
public class UserStoryControllerJpa {

    private UserStoryRepository userStoryRepository;

    public UserStoryControllerJpa(UserStoryRepository userStoryRepository) {
        super();
        this.userStoryRepository = userStoryRepository;
    }

    @RequestMapping("list-user-story")
    public String listAllUserStories(ModelMap model) {
       	String username = getLoggedInUsername(model);
    	List<UserStory> userStories = userStoryRepository.findByName(username);
        model.addAttribute("userStories", userStories);
        return "listUserStory";
    }
    
	// ITEC-445 SEC04-J Protect sensitive operations with security manager checks
	// The following code is used to authenticate the user 
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		
	}

    // GET only need separate method for POST
    @RequestMapping(value = "add-user-story", method = RequestMethod.GET)
    public String showNewUserStoryPage(ModelMap model) {
    	String username = getLoggedInUsername(model);
        UserStory userStory = new UserStory(1, username, "Enter Persona", "Enter What to do?",
                "Enter Why to do it?", false, 2, "URL");
        model.put("userStory", userStory);
        return "userStory";
    }

    @RequestMapping(value = "add-user-story", method = RequestMethod.POST)
    public String addNewUserStoryPage(ModelMap model, @Valid UserStory userStory, BindingResult result) {
        if (result.hasErrors()) {
            return "userStory";
        }

        userStoryRepository.save(userStory);
        return "redirect:list-user-story";
    }

    @RequestMapping("delete-user-story")
    public String deleteUserStory(@RequestParam int id) {
        userStoryRepository.deleteById(id);
        return "redirect:list-user-story";
    }

    @RequestMapping(value = "update-user-story", method = RequestMethod.GET)
    public String showUpdateUserStoryPage(@RequestParam int id, ModelMap model) {
        UserStory userStory = userStoryRepository.findById(id).get();
        model.addAttribute("userStory", userStory);
        return "userStory";
    }

    @RequestMapping(value = "update-user-story", method = RequestMethod.POST)
    public String updateUserStory(ModelMap model, @Valid UserStory userStory, BindingResult result) {
        if (result.hasErrors()) {
            return "userStory";
        }

        userStoryRepository.save(userStory);
        return "redirect:list-user-story";
    }
}