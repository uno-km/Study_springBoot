package com.aPlatformers.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aPlatformers.DTO.ResponseDTO;
import com.aPlatformers.DTO.UserDTO;
import com.aPlatformers.model.UserEntity;
import com.aPlatformers.service.UserService;

@Service
public class RegistUserCO {
	@Autowired
	private UserService userService;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public ResponseEntity<?> registUser(UserDTO userDTO) {
		try {
			System.out.println(userDTO.getAuth());
			UserEntity user = UserEntity.builder().email(userDTO.getEmail()).username(userDTO.getUsername())
					.password(passwordEncoder.encode(userDTO.getPassword())).build();
			// 서비스를 이용해 리파지토리에 유저 저장
			UserEntity registeredUser = userService.createUser(user);
			UserDTO responseUserDTO = UserDTO.builder().email(registeredUser.getEmail()).id(registeredUser.getId())
					.username(registeredUser.getUsername()).build();
			// 유저 정보는 항상 하나이므로 그냥 리스트로 만들어야하는 ResponseDTO를 사용하지 않고 그냥 UserDTO 리턴.
			return ResponseEntity.ok(responseUserDTO);
		} catch (Exception e) {
			// 사용자 정보는 항상 하나이므로 리스트로 만들어야하는 ResponseDTO를 사용하지 않고 그냥 UserDTO리턴하도록 함
			ResponseDTO<Object> responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}
}
