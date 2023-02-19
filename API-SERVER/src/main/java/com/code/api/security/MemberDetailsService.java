package com.code.api.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.code.api.service.UserService;
import com.code.api.vo.UserVo;

@Service
public class MemberDetailsService implements UserDetailsService{
	
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        System.out.println("OK/"+ username + "/BK" );
			UserVo user = userService.getUserInfo(username);
	        if (user == null){
	            throw new UsernameNotFoundException("User not authorized.");
	        }
	        return new MemberDetails(user);
	    }
	
}
