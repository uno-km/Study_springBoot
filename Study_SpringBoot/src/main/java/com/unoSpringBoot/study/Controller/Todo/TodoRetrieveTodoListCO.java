package com.unoSpringBoot.study.Controller.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.UnoDOC.Return;
import com.unoSpringBoot.study.model.TodoEntity;
import com.unoSpringBoot.study.service.TodoService;

@Service
public class TodoRetrieveTodoListCO {

	@Autowired
	private TodoService service;

	public ResponseEntity<?> TodoRetrieveTodoList(String userId) {
		try {
			// 데이터셋팅
			List<TodoEntity> entities = service.retrieveTodo("KIM_EUN_HO");
			return Return.returnList(entities);
		} catch (Exception e) {
			return Return.returnError(e);
		}

	}
}
