package com.aPlatformers.SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aPlatformers.Controller.Todo.TodoCreaeteCO;
import com.aPlatformers.Controller.Todo.TodoDeleteCO;
import com.aPlatformers.Controller.Todo.TodoRetrieveTodoListCO;
import com.aPlatformers.Controller.Todo.TodoUpdateCO;
import com.aPlatformers.DTO.TodoDTO;

@RestController
@RequestMapping("/todo")
public class TodoSO {

	@Autowired
	TodoRetrieveTodoListCO todoRetrieveTodoListCO;
	@Autowired
	TodoCreaeteCO todoCreateCO;
	@Autowired
	TodoUpdateCO todoUpdateCO;
	@Autowired
	TodoDeleteCO todoDeleteCO;

	@PostMapping
	public ResponseEntity<?> createTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto) { // todo생성
		return todoCreateCO.createTodo(userId, dto);
	}

	@GetMapping
	public ResponseEntity<?> retrieveTodoList(@AuthenticationPrincipal String userId) { // 리스트반환
		return todoRetrieveTodoListCO.TodoRetrieveTodoList(userId);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto) { // todo삭제
		return todoDeleteCO.deleteTodo(userId, dto);
	}

	@PutMapping
	public ResponseEntity<?> updateTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto) { // todo수정
		return todoUpdateCO.updateTodo(userId, dto);
	}

}
