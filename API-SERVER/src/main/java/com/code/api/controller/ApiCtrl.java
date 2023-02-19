package com.code.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.api.dto.UserDto;
import com.code.api.service.UserService;

@RestController
public class ApiCtrl {
	
	/*
	@Autowired
	private UserService service;
	
	@GetMapping("/userList")
	public List<User> getUserList1(){
		return service.getUserList();
	}
	*/
}
