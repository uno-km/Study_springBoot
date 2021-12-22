//package com.aPlatformers.Controller.User;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.aPlatformers.DTO.UserDTO;
//import com.aPlatformers.UnoDOC.Validate;
//import com.aPlatformers.model.UserEntity;
//import com.aPlatformers.service.UserService;
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
