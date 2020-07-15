package io.javabrains.springSecurity;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@Autowired
	MyUserDetailsService userService;
	@RequestMapping("/home")
	public String home(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_HOME");
		return "home.jsp";
	}
	@RequestMapping("/admin")
	public String admin(HttpServletRequest request)
	{
		return "admin.jsp";
	}
	@RequestMapping("/student")
	public String student(HttpServletRequest request)
	{
		return "student.jsp";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		
		request.setAttribute("mode","MODE_LOGIN");
		return "home.jsp";
	}
	@RequestMapping("/register")
	public String registeration(HttpServletRequest request,Model model)
	{
		user userobj=new user();
		model.addAttribute("userobj",userobj);
		request.setAttribute("mode","MODE_REGISTER");
		return "home.jsp";
	}
	@RequestMapping(method = RequestMethod.POST,value = "/registeruser")
	public  String registerUser(@ModelAttribute("userobj") user u,HttpServletRequest request,Model model)
	{
		
		request.setAttribute("mode","MODE_REGISTER");
		String option=request.getParameter("op");
		if(userService.isUserAlreadyPresent(u))
		{
			model.addAttribute("msg","failure duplicate");
			return "home.jsp";
		}
		else
		{
			userService.saveUser(u,option);
			model.addAttribute("msg","success register");
			return "home.jsp";		
		}
		
	}
	
	@RequestMapping("/profile")
	public String getProfile(Model model,Principal principal,HttpServletRequest request)
	{
		String id=principal.getName();
		user userobj=userService.findUser(id);
		request.setAttribute("mode","MODE_PROFILE");
		
		model.addAttribute("userobj",userobj);
		return "home.jsp";
	}
	
//	  ${SPRING_SECURITY_LAST_EXCEPTION.message}

//	<input type="hidden" name="id" value="${userobj.id}">

}
