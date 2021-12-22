package com.UnoDOC;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.aPlatformers.DTO.ResponseDTO;
import com.aPlatformers.DTO.TodoDTO;
import com.aPlatformers.model.TodoEntity;

public class Return {
	public static ResponseEntity<ResponseDTO<TodoDTO>> returnList(final List<TodoEntity> entities) {
		List<TodoDTO> outDTO = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(outDTO).build();
		return ResponseEntity.ok().body(response);
	}

	public static ResponseEntity<ResponseDTO<TodoDTO>> returnError(Exception e) {
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(e.getMessage()).build();
		return ResponseEntity.badRequest().body(response);
	}

}
