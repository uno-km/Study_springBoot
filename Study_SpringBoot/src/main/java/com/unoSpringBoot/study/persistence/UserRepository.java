package com.unoSpringBoot.study.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unoSpringBoot.study.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	List<UserEntity> findByUserId(String userId);

	UserEntity findByEmail(String email);

	Boolean exitsByEmail(String email);

	UserEntity findByEmailAndPassword(String email, String password);
}
