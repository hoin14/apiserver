package com.code.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.code.api.security.MemberDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
		@Autowired
		private MemberDetailsService memberService;
	   
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		/**
	     * 규칙 설정
	     * @param http
	     * @throws Exception
	     */
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .antMatchers( "/login", "/singUp", "/access_denied", "/resources/**").permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
	                // USER, ADMIN 접근 허용
	                .antMatchers("/userAccess").hasRole("USER")
	                .antMatchers("/userAccess").hasRole("ADMIN")
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .loginProcessingUrl("/loginProc")
	                .defaultSuccessUrl("/")
	                .failureUrl("/access_denied") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보낸다.
	                .and()
	            .csrf().disable();		//로그인 창
	    }

	    /**
	     * 로그인 인증 처리 메소드
	     * @param auth
	     * @throws Exception
	     */
	    @Override
	    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
	    	authBuilder.userDetailsService(memberService).passwordEncoder(passwordEncoder());
	    }
}
