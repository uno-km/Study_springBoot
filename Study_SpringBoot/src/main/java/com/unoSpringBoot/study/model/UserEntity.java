package com.unoSpringBoot.study.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserEntity {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id; // 사용자에게 고유하게 부여되는 id
	@Column(nullable = false)
	private String username;// 사용자이름
	@Column(nullable = false)
	private String email;// 사용자의 이메일, 아이디와 같은 기능
	@Column(nullable = false)
	private String password;// 패스워드
}
