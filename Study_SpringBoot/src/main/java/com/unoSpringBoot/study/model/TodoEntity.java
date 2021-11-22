package com.unoSpringBoot.study.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoEntity {
	private String id; // 오브젝트의 아이디
	private String userId; //이 오브젝를 생성한 아이디
	private String title; //Todo타이틀
	private boolean done; //true - todo 를 완료 , 미완료했을때
	
}
