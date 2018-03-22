package com.walking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.walking.model.User;
import com.walking.service.UserService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private JedisPool jedisPool;
	
	
	@RequestMapping("/user/{id}")
	@ResponseBody
	public User getUserById(@PathVariable int id){
		System.out.println("-------------------------进入了controller");
		
		return userService.getUserById(id);
	}
	
	@RequestMapping("/signOut")
	public ModelAndView signOut(){
		ModelAndView mv = new ModelAndView("redirect:/login.jsp");
		return mv;
	}
	
	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(HttpServletRequest request,String password,String userName){
		ModelAndView mv = new ModelAndView();

		User user = userService.getUserByUserName(userName);
	
		if(user!=null){
			if(user.getPassword().equals(password)){
				mv.setViewName("redirect:");
				HttpSession session = request.getSession();
				session.setAttribute("userSession", user);
			}else{
				mv.addObject("error","密码错误");
				mv.setViewName("redirect:/login.jsp");
			}
		}else{
			mv.addObject("error","账号不存在");
			mv.setViewName("redirect:/login.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping("/toRegister")
	public ModelAndView toRegister(HttpServletRequest request,String password,String userName){
		ModelAndView mv = new ModelAndView("/register");

		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request,User user){
		ModelAndView mv = new ModelAndView("redirect:/login.jsp");
		userService.insertUser(user);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/testRedis")
	public String testRedis(HttpServletRequest request){
		
		Jedis jedis = jedisPool.getResource();
		
		jedis.set("test", "123");
		String string = jedis.get("test");
		return string;
	}
	
	
}
