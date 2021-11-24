package com.unoSpringBoot.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.model.TodoEntity;
import com.unoSpringBoot.study.persistence.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public String testService() {
		TodoEntity todoEntity = TodoEntity.builder().title("하위~").userId("KimEunHo").build();
		todoRepository.save(todoEntity);
		TodoEntity saveEntity = todoRepository.findById(todoEntity.getId()).get();
		return saveEntity.getUserId()+" <-- 아이디 , 제목 --> " + saveEntity.getTitle();
	}

}
