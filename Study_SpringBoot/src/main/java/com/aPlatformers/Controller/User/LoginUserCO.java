package com.aPlatformers.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aPlatformers.DTO.ResponseDTO;
import com.aPlatformers.DTO.UserDTO;
import com.aPlatformers.model.UserEntity;
import com.aPlatformers.security.TokenProvider;
import com.aPlatformers.service.UserService;

@Service
public class LoginUserCO {
	@Autowired
	private TokenProvider tokenProvider;
	@Autowired
	private UserService userService;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public ResponseEntity<?> authenticate(UserDTO userDTO) {
		UserEntity user = userService.getByCredentials(userDTO.getEmail(), userDTO.getPassword(), passwordEncoder);

		if (user != null) {
			// 여기서 부터 토큰생성을 해주는 기능을 넣어준다!
			System.out.println(passwordEncoder);
			final String token = tokenProvider.create(user);
			final UserDTO responseUserDTO = UserDTO.builder().email(user.getUsername()).id(user.getId()).token(token)
					.build();
			return ResponseEntity.ok().body(responseUserDTO);
		} else {
			ResponseDTO<?> responseDTO = ResponseDTO.builder().error("로그인 실패 ㅠ").build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}
}
