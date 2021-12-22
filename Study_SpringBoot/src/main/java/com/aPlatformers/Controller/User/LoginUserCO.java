package com.unoSpringBoot.study.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.DTO.ResponseDTO;
import com.unoSpringBoot.study.DTO.UserDTO;
import com.unoSpringBoot.study.model.UserEntity;
import com.unoSpringBoot.study.security.TokenProvider;
import com.unoSpringBoot.study.service.UserService;

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
