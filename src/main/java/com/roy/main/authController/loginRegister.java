package com.roy.main.authController;





import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.roy.main.model.User;
import com.roy.main.repository.UserRepo;

import jakarta.servlet.http.HttpSession;



@Controller

public class loginRegister {
	
	@Autowired
	UserRepo ur;
	


	@GetMapping("/login")
	public String login() {
		
		
		return "login.html";
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register.html";
	}
	
	@GetMapping("/")
	public String home(HttpSession session){
		
		User status = (User) session.getAttribute("msg");
		System.out.println(status);
		if(status == null)
		{
			return "redirect:/login";
			
		}
		else {
			return "home.html";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.setAttribute("msg" , null);
		return "redirect:/";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user, @RequestParam("confirm") String confirm) {
		

		if(user.getPassword().equals(confirm)) {
			ur.save(user);
			return "redirect:/login";
		}
		else {
		return "redirect:/register";
		}
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session)
	{
		User user = ur.findByUsernameAndPassword(username, password);
		if(Objects.nonNull(user))
		{
			
			session.setAttribute("msg" , user);
	
			return "redirect:/";
		}
		else {
			return "redirect:/login";
		}
		
	}
}
