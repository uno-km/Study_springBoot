package com.aPlatformers.SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aPlatformers.Controller.User.FindUserInfoCO;
import com.aPlatformers.Controller.User.LoginUserCO;
import com.aPlatformers.Controller.User.RegistUserCO;
import com.aPlatformers.DTO.UserDTO;

@RestController
@RequestMapping("auth")
public class UserSO {
	@Autowired
	RegistUserCO registUserCO;
	@Autowired
	LoginUserCO loginUserCO;
	@Autowired
	FindUserInfoCO findUserInfoCO;

	@PostMapping("/signup")
	public ResponseEntity<?> registUser(@RequestBody UserDTO userDTO) {
		return registUserCO.registUser(userDTO);
	}

	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody UserDTO userDTO) {
		return loginUserCO.authenticate(userDTO);
	}

	@PostMapping("/find")
	public ResponseEntity<?> changeUserInfo(@RequestBody UserDTO userDTO) {
		return findUserInfoCO.findUserInfo(userDTO);
	}
//	@PostMapping("/change")
//	public UserEntity changeUserInfo(@RequestBody UserDTO userDTO) {
//		return changeUserInfoCO.changeUserInfo(userDTO);
//	}
}
