package com.UnoDOC;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.aPlatformers.DTO.UserDTO;
import com.aPlatformers.model.TodoEntity;
import com.aPlatformers.model.UserEntity;
import com.aPlatformers.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Validate {
	public static void checkValidate(final TodoEntity entity) {
		if (entity == null) {
			log.warn("엔티티값이 널값임");
			throw new RuntimeException("엔티티에 널값이..ㅠ");
		}
		if (entity.getUserId() == null) {
			log.warn("해당하는 값이없다.");
			throw new RuntimeException("해당하는 값이없다.");
		}
	}

	public static boolean checkLoginSession(final UserDTO userDTO) {
		// Todo : http 클래스를 이용해서 세션값을 받아 계속 로그인이 되어있는지,권환을 확인한다.
		String sessionEmail = "zhfldk014745@naver.com";
		String sessionName = "김은호";

		if (!"".equals(userDTO.getEmail()) || !"".equals(userDTO.getUsername())) {
			if (sessionEmail.equals(userDTO.getEmail()) && sessionName.equals(userDTO.getUsername())) {
				return true;
			}
		}
		return false;
	}

	public static void NONE_userCheck(UserDTO userDTO) {
		UserService service = new UserService();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		UserEntity user = service.getByCredentials(userDTO.getEmail(), userDTO.getPassword(), passwordEncoder);
		if (user.getEmail().length() == 0 || user == null) {

		}
	}
}
