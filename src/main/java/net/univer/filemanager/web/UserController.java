package net.univer.filemanager.web;

import net.univer.filemanager.domain.Role;
import net.univer.filemanager.domain.User;
import net.univer.filemanager.service.RoleService;
import net.univer.filemanager.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping("/index")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	@RequestMapping("/adduser")
	public String add(@ModelAttribute("user") User user, BindingResult result) {
		return "adduser";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,
			BindingResult result) {

		userService.addUser(user);
		roleService.addRole(new Role(), user.getId());

		return "redirect:/index";
	}

}
