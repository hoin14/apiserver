package com.code.apiserver.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.apisever.model.User;

@RestController
public class ApiCtrl {
	
	private Map<String, User> userMap;
	
	@PostConstruct
	public void init() {
		userMap = new HashMap<String, User>();
		userMap.put("1", new User("1", "선호"));
		userMap.put("2", new User("2", "영수"));
		userMap.put("3", new User("3", "건호"));
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") String id) {
		return userMap.get(id);
	}
	
	@GetMapping("/user/all")
	public List<User> getUserList(){
		return new ArrayList<User>(userMap.values());
	}
	
	@PutMapping("/user/{id}")
	public void putUser(@PathVariable("id") String id, @RequestParam("name") String name) {
		User user = new User(id, name);
		userMap.put(id, user);
	}

	@PostMapping("/user/{id}")
	public void postUser(@PathVariable("id") String id, @RequestParam("name") String name) {
		User user = userMap.get(id);
		user.setUserId(id);
		user.setUserName(name);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteuser(@PathVariable("id") String id, @RequestParam("name") String name) {
		userMap.remove(id);
	}
	
}
