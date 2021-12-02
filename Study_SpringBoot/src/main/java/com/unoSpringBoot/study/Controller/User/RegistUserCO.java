package com.unoSpringBoot.study.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.DTO.ResponseDTO;
import com.unoSpringBoot.study.DTO.UserDTO;
import com.unoSpringBoot.study.model.UserEntity;
import com.unoSpringBoot.study.service.UserService;

@Service
public class RegistUserCO {
	@Autowired
	private UserService userService;

	public ResponseEntity<?> registUser(UserDTO userDTO) {
		try {
			UserEntity userEntity = UserEntity.builder().email(userDTO.getEmail()).userName(userDTO.getUsername())
					.password(userDTO.getPassword()).build();
			// 서비스를 이용해 리포지터리에 사용자 저장
			UserEntity registeredUser = userService.createUser(userEntity);
			UserDTO responseUserDTO = UserDTO.builder().email(registeredUser.getEmail()).id(registeredUser.getId())
					.username(registeredUser.getUserName()).build();
			return ResponseEntity.ok().body(responseUserDTO);
		} catch (Exception e) {
			// 사용자 정보는 항상 하나이므로 리스트로 만들어야하는 ResponseDTO를 사용하지 않고 그냥 UserDTO리턴하도록 함
			ResponseDTO<Object> responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}
}
