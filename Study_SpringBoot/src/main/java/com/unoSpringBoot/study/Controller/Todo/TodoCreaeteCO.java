package com.unoSpringBoot.study.Controller.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.DTO.TodoDTO;
import com.unoSpringBoot.study.UnoDOC.Return;
import com.unoSpringBoot.study.model.TodoEntity;
import com.unoSpringBoot.study.service.TodoService;

@Service
public class TodoCreaeteCO {

	@Autowired
	private TodoService service;

	public <R> ResponseEntity<?> createTodo(String userId, TodoDTO dto){
		try {
			// 데이터셋팅
			TodoEntity todoEntity = TodoDTO.setEntity(dto);
			todoEntity.setId(null);
			todoEntity.setUserId(userId);
			List<TodoEntity> entities = service.createTodo(todoEntity);
			return Return.returnList(entities);
		} catch (Exception e) {
			return Return.returnError(e);

		}
	}
}
