package com.unoSpringBoot.study.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unoSpringBoot.study.DTO.ResponseDTO;
import com.unoSpringBoot.study.DTO.TodoDTO;
import com.unoSpringBoot.study.model.TodoEntity;
import com.unoSpringBoot.study.service.TodoService;

@RestController
@RequestMapping("todo")
public class TodoController {

	@Autowired
	private TodoService service;

	@GetMapping("/badConnect")
	public ResponseEntity<?> testControllerResponseEntity() {
		List<String> list = new ArrayList<String>();
		list.add("하위~~~~  내이름은 오류 400이야!! 반가워!!");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.badRequest().body(response);
	}

	@PostMapping
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto) {
		try {
			String temporartUserId = "김은호";
			TodoEntity todoEntity = TodoDTO.toEntity(dto);
			todoEntity.setId(null);
			todoEntity.setUserId(temporartUserId);
			List<TodoEntity> entities = service.createTodo(todoEntity);
			List<TodoDTO> outDTO = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(outDTO).build();

			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error("오류").build();
			return ResponseEntity.badRequest().body(response);
		}
	}

}
