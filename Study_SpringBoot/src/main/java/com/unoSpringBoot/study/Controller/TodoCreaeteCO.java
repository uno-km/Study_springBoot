package com.unoSpringBoot.study.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.DTO.ResponseDTO;
import com.unoSpringBoot.study.DTO.TodoDTO;
import com.unoSpringBoot.study.model.TodoEntity;
import com.unoSpringBoot.study.service.TodoService;

@Service
public class TodoCreaeteCO {

	@Autowired
	private TodoService service;

	private final String USER_ID = "KIM_EUN_HO";

	public <R> ResponseEntity<?> createTodo(TodoDTO dto) {
		try {
			//데이터셋팅
			TodoEntity todoEntity = TodoDTO.setEntity(dto);
			todoEntity.setId(null);
			todoEntity.setUserId(USER_ID);
			
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
