package com.unoSpringBoot.study.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;

import com.unoSpringBoot.study.DTO.UserDTO;
import com.unoSpringBoot.study.service.UserService;

public class ChangeUserInfoCO {
	@Autowired
	private UserService service;

	public boolean checkUserPassword(UserDTO userDTO) {
		String sessionPW = "";
		if (sessionPW == userDTO.getPassword()) {
			return service.checkUserPassword(userDTO.getPassword());

		}
		return service.checkUserPassword(userDTO.getPassword());
	}
}
