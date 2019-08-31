package com.briup.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.briup.bean.User;
import com.briup.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(User user,RedirectAttributes redirectAttributes){
		
		try {
			userService.register(user);
			redirectAttributes.addFlashAttribute("msg", "注册成功!");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("msg", "注册失败!");
			return "redirect:/error";
		}
		
		return "redirect:/success";
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public List<User> getAll(){
		List<User> list = null;
		try {
			list = userService.findAllUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
