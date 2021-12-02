package com.unoSpringBoot.study.SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unoSpringBoot.study.Controller.Todo.TodoController;
import com.unoSpringBoot.study.Controller.Todo.TodoCreaeteCO;
import com.unoSpringBoot.study.Controller.Todo.TodoDeleteCO;
import com.unoSpringBoot.study.Controller.Todo.TodoRetrieveTodoListCO;
import com.unoSpringBoot.study.Controller.Todo.TodoUpdateCO;
import com.unoSpringBoot.study.DTO.TodoDTO;

@RestController
@RequestMapping("todo")
public class TodoSO {

	@Autowired
	TodoRetrieveTodoListCO todoRetrieveTodoListCO;
	@Autowired
	TodoController todoController;
	@Autowired
	TodoCreaeteCO todoCreateCO;
	@Autowired
	TodoUpdateCO todoUpdateCO;
	@Autowired
	TodoDeleteCO todoDeleteCO;

	@GetMapping("/badConnect")
	public ResponseEntity<?> testControllerResponseEntity() { // 태스트용 /badConnect
		return todoController.testControllerResponseEntity();
	}

	@PostMapping
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto) { // todo생성
		return todoCreateCO.createTodo(dto);
	}

	@GetMapping
	public ResponseEntity<?> retrieveTodoList() { // 리스트반환
		return todoRetrieveTodoListCO.TodoRetrieveTodoList();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteTodo(@RequestBody TodoDTO dto) { // todo삭제
		return todoDeleteCO.deleteTodo(dto);
	}

	@PutMapping
	public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto) { // todo수정
		return todoUpdateCO.updateTodo(dto);
	}

}
