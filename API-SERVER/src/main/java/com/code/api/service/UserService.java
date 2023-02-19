package com.code.api.service;

import org.springframework.stereotype.Service;

import com.code.api.vo.UserVo;

@Service
public interface UserService {

	//public List<UserDto> getUserList();
	public UserVo getUserInfo(String userName);
	public void insertUserInfo(UserVo userVo);
	
	
}
