package com.unoSpringBoot.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.model.UserEntity;
import com.unoSpringBoot.study.persistence.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserEntity createUser(final UserEntity userEntity) {
		if (userEntity == null || userEntity.getEmail() == null) {
			throw new RuntimeException("유효하지 않은 값이 들어왔습니다!");
		}
		final String email = userEntity.getEmail();
		if (userRepository.existsByEmail(email)) {
			log.warn("이 이메일은 이미 있습니다. {}", email);
			throw new RuntimeException("이 이메일은 이미 있습니다.");
		}
		return userRepository.save(userEntity);
	}

	public UserEntity getByCredentials(final String email, final String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

//	public UserEntity changeUserInfo(final String password) {
//		return userRepository.changeUserInfo(password);
//	}
//
//	public boolean checkUserPassword(final String password) {
//		return userRepository.checkUserPassword(password);
//	}

}
