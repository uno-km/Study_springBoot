package com.aPlatformers.Controller.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aPlatformers.DTO.TodoDTO;
import com.aPlatformers.UnoDOC.Return;
import com.aPlatformers.model.TodoEntity;
import com.aPlatformers.service.TodoService;

@Service
public class TodoCreaeteCO {

	@Autowired
	private TodoService service;

	public <R> ResponseEntity<?> createTodo(String userId, TodoDTO dto) {
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
