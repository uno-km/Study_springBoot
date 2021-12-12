package com.unoSpringBoot.study.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.DTO.ResponseDTO;
import com.unoSpringBoot.study.DTO.UserDTO;
import com.unoSpringBoot.study.model.UserEntity;
import com.unoSpringBoot.study.service.UserService;

@Service
public class FindUserInfoCO {
	@Autowired
	private UserService service;

	public ResponseEntity<?> findUserInfo(UserDTO userDTO) {
		try {
			UserEntity userEntity = service.findByEmailAndUsername(userDTO.getEmail(), userDTO.getUsername());
			final UserDTO responseUserDTO = UserDTO.builder().username(userEntity.getUsername())
					.email(userEntity.getEmail()).auth(userEntity.getAuth()).password(userEntity.getPassword()).build();
			return ResponseEntity.ok().body(responseUserDTO);
		} catch (Exception e) {
			// 사용자 정보는 항상 하나이므로 리스트로 만들어야하는 ResponseDTO를 사용하지 않고 그냥 UserDTO리턴하도록 함
			ResponseDTO<Object> responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}
}
