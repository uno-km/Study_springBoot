package com.unoSpringBoot.study.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.DTO.ResponseDTO;
import com.unoSpringBoot.study.DTO.UserDTO;
import com.unoSpringBoot.study.model.UserEntity;
import com.unoSpringBoot.study.service.UserService;

@Service
public class LoginUserCO {
	@Autowired
	private UserService service;

	public ResponseEntity<?> authenticate(UserDTO userDTO) {
		UserEntity user = service.getByCredentials(userDTO.getEmail(), userDTO.getPassword());
		if (user != null) {
			final UserDTO responseUserDTO = UserDTO.builder().email(user.getUsername()).id(user.getId()).build();
			return ResponseEntity.ok().body(responseUserDTO);
		} else {
			ResponseDTO<?> responseDTO = ResponseDTO.builder().error("로그인 실패 ㅠ").build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}
}
