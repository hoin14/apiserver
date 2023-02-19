package com.code.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.api.dto.User;
import com.code.api.mapper.UserMapper;
import com.code.api.service.UserService;

@RestController
public class ApiCtrl {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/userList")
	public List<User> getUserList1(){
		return service.getUserList();
	}
}
