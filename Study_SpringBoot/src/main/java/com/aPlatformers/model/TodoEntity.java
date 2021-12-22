package com.aPlatformers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
//@Entity에 이름을 부여할수있다. @Entity("TodoEntity)
@Table(name = "Todo")
public class TodoEntity {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id; // 오브젝트의 아이디
	private String userId; // 이 오브젝를 생성한 아이디
	private String title; // Todo타이틀
	private boolean done; // true - todo 를 완료 , 미완료했을때
}