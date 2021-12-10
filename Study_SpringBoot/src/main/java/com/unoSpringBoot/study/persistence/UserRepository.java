package com.unoSpringBoot.study.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unoSpringBoot.study.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	UserEntity findByEmail(String email);

	Boolean existsByEmail(String email);

	UserEntity findByEmailAndPassword(String email, String password);

	UserEntity findByEmailAndUsername(String email, String password);

//	UserEntity changeUserInfo(String password);
//	boolean checkUserPassword(String password);
}
