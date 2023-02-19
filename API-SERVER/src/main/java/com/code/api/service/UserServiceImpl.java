package com.code.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.api.dao.UserDao;
import com.code.api.dto.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

}
