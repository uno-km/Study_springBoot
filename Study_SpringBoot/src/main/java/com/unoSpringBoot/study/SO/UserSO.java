package com.unoSpringBoot.study.SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unoSpringBoot.study.Controller.User.LoginUserCO;
import com.unoSpringBoot.study.Controller.User.RegistUserCO;
import com.unoSpringBoot.study.DTO.UserDTO;


@RestController
@RequestMapping("auth")
public class UserSO {
	@Autowired
	RegistUserCO registUserCO;
	@Autowired
	LoginUserCO loginUserCO;

	@PostMapping("/signup")
	public ResponseEntity<?> registUser(@RequestBody UserDTO userDTO) {
		return registUserCO.registUser(userDTO);
	}

	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody UserDTO userDTO) {
		return loginUserCO.authenticate(userDTO);
	}

}
