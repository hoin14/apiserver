package com.code.api.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.code.api.vo.UserVo;

@Mapper
@Repository
public interface UserDao {
	
	//List<UserDto> getUserList();
	public UserVo getUserInfo(String userName);
	public void insertUserInfo(UserVo userVo);
}
