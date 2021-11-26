package com.unoSpringBoot.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.UnoDOC.Validate;
import com.unoSpringBoot.study.model.TodoEntity;
import com.unoSpringBoot.study.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public String testService() {
		TodoEntity todoEntity = TodoEntity.builder().title("하위~").userId("KimEunHo").build();
		todoRepository.save(todoEntity);
		TodoEntity saveEntity = todoRepository.findById(todoEntity.getId()).get();
		return saveEntity.getUserId();
	}

	public List<TodoEntity> createTodo(final TodoEntity entity) {
		Validate.checkValidate(entity);
		todoRepository.save(entity);
		log.info("entity id : {} is saved", entity.getId());
		return todoRepository.findByUserId(entity.getUserId());
	}
}
