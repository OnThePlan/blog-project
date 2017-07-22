package kr.co.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.blog.service.LoginService;
import kr.co.blog.vo.Test;

// login controller
@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public @ResponseBody Test test() {
		
		System.out.println("Welcome!! Login Controller!!");
		Test result = new Test();
		result.setTest("aaaa");
		result.setTest2(123);
		System.out.println("이게 무슨 일이야");
		return result;
		
		///moon test test dajeong

	}

}
