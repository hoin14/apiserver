package com.code.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.code.api.dto.User;

@Mapper
@Repository
public interface UserDao {
	List<User> getUserList();
}
