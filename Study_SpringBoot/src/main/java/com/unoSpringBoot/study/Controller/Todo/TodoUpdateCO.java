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
public class TodoUpdateCO {

	@Autowired
	private TodoService service;

	public ResponseEntity<?> updateTodo(String userId, TodoDTO dto) {
		try {
			TodoEntity todoEntity = TodoDTO.setEntity(dto);
			todoEntity.setUserId(userId);
			List<TodoEntity> entities = service.updateTodo(todoEntity);
			return Return.returnList(entities);
		} catch (Exception e) {
			return Return.returnError(e);
		}
	}
}
