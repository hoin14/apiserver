package com.code.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.api.dao.UserDao;
import com.code.api.vo.UserVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	/*
	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}
	 */
	
	public UserVo getUserInfo(String userName) {
		UserVo user = userDao.getUserInfo(userName);
		return user;
	}

	@Transactional
	public void insertUserInfo(UserVo userVo) {
		System.out.println("2:"+ userVo.toString());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVo.setUserPw(passwordEncoder.encode(userVo.getUserPw()));
        userVo.setUserAuth("USER");
        userDao.insertUserInfo(userVo);
	}
	
	/*
	@Override
    public UserVo loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserVo userVo = userDao.getUserInfo(userId);
        if (userVo == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        return userVo;
    }
    */

}
