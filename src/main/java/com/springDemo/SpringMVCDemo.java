package com.springDemo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// Git pull request Test
// Removed Test
@Controller
@RequestMapping(value="/")
public class SpringMVCDemo {
	@Autowired
	public JdbcTemplate jdbcSpring;
	
//	@Autowired 
//	public DataSource dataSource;
	
//	@Autowired
//	public LoginService loginService;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView helloWorldExample(HttpServletRequest request,
			HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("message", "Welcome to spring mvc"); 
		 
		
		
		return mv;
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginWithDatabase(@RequestParam( value="userName",required=false) String userName,@RequestParam(value ="pass",required=false) String pass){
		System.out.println("userName->" +userName);
		System.out.println("password->" +pass); 
		
		String sql="select * from user where username ="+"'"+userName+"'"+" and password = "+"'"+pass+"'";
//		String sql="select * from user";
		System.out.println(sql);
		
		List<User> user =  jdbcSpring.query(sql,  new UserMapper());
		if(!user.isEmpty()){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("success");
			mv.addObject("message", "you are inside");
			return mv;
		}
		else{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index");
			mv.addObject("result", "username and password not valid!");
			return mv;
		}
		
	}
	
	/*@RequestMapping(value="/loginUsingService",method=RequestMethod.POST)
	public ModelAndView loginUsingService(@RequestParam( value="userName",required=false) String userName,@RequestParam(value ="pass",required=false) String pass){
		boolean isValidUser = loginService.testUser(userName,pass);
		
		if(isValidUser){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("success");
			mv.addObject("message", "you are inside");
			return mv;
		}
		else{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index");
			mv.addObject("result", "username and password not valid!");
			return mv;
		}
		
	}*/
	
	/*@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginExample(@RequestParam( value="userName",required=false) String userName,@RequestParam(value ="pass",required=false) String pass){
		System.out.println("userName->" +userName);
		System.out.println("password->" +pass); 
		if(!userName.equals("")&& userName!="" && !pass.equals("") && pass!=""){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		mv.addObject("message", "you are inside");
		return mv;
		}
		else
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index");
			mv.addObject("result", "username and password required!");
			return mv;
		}
	}*/
	
	
}
