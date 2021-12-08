package com.unoSpringBoot.study.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {
	private String token;
	private String email;
	private String username;
	private String password;
	private String id;
	private String auth;
}
