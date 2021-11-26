package com.unoSpringBoot.study.SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unoSpringBoot.study.Controller.TodoController;
import com.unoSpringBoot.study.Controller.TodoCreaeteCO;
import com.unoSpringBoot.study.Controller.TodoRetrieveTodoListCO;
import com.unoSpringBoot.study.DTO.TodoDTO;

@RestController
@RequestMapping("todo")
public class TodoSO {

	@Autowired
	TodoController todoController;

	@GetMapping("/badConnect")
	public ResponseEntity<?> testControllerResponseEntity() {
		return todoController.testControllerResponseEntity();
	}

	@Autowired
	TodoCreaeteCO todoCreateCO;

	@PostMapping("/CreateTodo")
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto) {
		return todoCreateCO.createTodo(dto);
	}

	@Autowired
	TodoRetrieveTodoListCO todoRetrieveTodoListCO;

	@GetMapping("/")
	public ResponseEntity<?> retrieveTodoList() {
		return todoRetrieveTodoListCO.TodoRetrieveTodoList();
	}

}
