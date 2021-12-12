package com.unoSpringBoot.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

import com.unoSpringBoot.study.security.JwtAuthenticationFilter;

import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http시큐리티 빌더
		http.cors()// webMvcConfig에서 이미 설정했으므로 기본 cors 설정
				.and().csrf().disable()// csrf는 현재 사용하지 않으므로 disable
				.httpBasic().disable() // token을 사용하므로 basic인증 disalbe
				.sessionManagement()// session 기반이 아님을 선언
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/", "/auth/**").permitAll() // '/'와 '/auth/**' 경로는 인증을 안해도됨 을선언
				.anyRequest().authenticated(); // /와 /auth/**이외의 모든 경로는 인증해야함
		/*
		 * filter등록 매 요청마다 CorsFilter 실행후에 jwtAuthenticationFilter를 실행한다.
		 */
		http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);
	}
}
