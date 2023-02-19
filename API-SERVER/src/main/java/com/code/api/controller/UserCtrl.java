package com.code.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.code.api.service.UserService;
import com.code.api.vo.UserVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserCtrl {
	
	  @Autowired	
	  private UserService userService;

	    /**
	     * localhost:8080 시 login 으로 redirect
	     * @return
	     */
	    @GetMapping
	    public String root() {
	        return "redirect:/login";
	    }

	    /**
	     * 로그인 폼
	     * @return
	     */
	    @GetMapping("/login")
	    public String login(){
	        return "login";
	    }

	   
	    @GetMapping("/signUp")
	    public String signUpForm() {
	        return "signUp";
	    }
	   
	    /**
	     * 로그인 실패 폼
	     * @return
	     */
	    @GetMapping("/access_denied")
	    public String accessDenied() {
	        return "accessDenied";
	    }

	    /**
	     * 회원가입 진행
	     * @param userVo
	     * @return
	     */
	    @PostMapping("/signUp")
	    public String signUp(UserVo userVo) {
	    	System.out.println("1:" + userVo.toString());
	        userService.insertUserInfo(userVo);
	        return "redirect:/login";
	    }

	    /**
	     * 유저 페이지
	     * @param model
	     * @param authentication
	     * @return
	     */
	    @GetMapping("/user_access")
	    public String userAccess(Model model, Authentication authentication) {
	        UserVo userVo = (UserVo) authentication.getPrincipal(); 
	        model.addAttribute("info", userVo.getUserName());
	        return "loginAccess";
	    }
	    
}
