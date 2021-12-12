//package com.unoSpringBoot.study.Controller.User;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.unoSpringBoot.study.DTO.UserDTO;
//import com.unoSpringBoot.study.UnoDOC.Validate;
//import com.unoSpringBoot.study.model.UserEntity;
//import com.unoSpringBoot.study.service.UserService;
//
//public class ChangeUserInfoCO {
//	@Autowired
//	private UserService service;
//
//	public UserEntity changeUserInfo(UserDTO userDTO) {
//		if (Validate.checkValidateSession(userDTO.getPassword())) {
//			return service.changeUserInfo(userDTO.getPassword());
//		}
//		return null;
//	}
//}
