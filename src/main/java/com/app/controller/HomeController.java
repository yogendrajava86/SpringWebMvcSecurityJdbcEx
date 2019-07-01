package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"uname"})
public class HomeController {
 

	
	@RequestMapping("/all")
	public String showAll() {
		
		return "AllPage";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(ModelMap m) {
		
		m.addAttribute("uname","test");
		return "AdminPage";
	}
	
	@RequestMapping("/emp")
	public String showEmp() {
		return "EmployeePage";
	}
	
	@RequestMapping("/common")
	public String showCommon() {
		return "CommonPage";
	}
	
	@RequestMapping("/denied")
	public String showDenied() {
		return "DeniedPage";
	}
}
