package com.unoSpringBoot.study.SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unoSpringBoot.study.Controller.TodoController;
import com.unoSpringBoot.study.Controller.TodoCreaeteCO;
import com.unoSpringBoot.study.Controller.TodoRetrieveTodoListCO;
import com.unoSpringBoot.study.Controller.TodoUpdateCO;
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

	@GetMapping("/badConnect")
	public ResponseEntity<?> testControllerResponseEntity() { //태스트용 /badConnect
		return todoController.testControllerResponseEntity();
	}

	@PostMapping("/createTodo")
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto) { //todo생성
		return todoCreateCO.createTodo(dto);
	}

	@GetMapping
	public ResponseEntity<?> retrieveTodoList() { //리스트반환
		return todoRetrieveTodoListCO.TodoRetrieveTodoList();
	}

	@PutMapping
	public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto) { //todo수정
		return todoUpdateCO.updateTodo(dto);
	}

}
