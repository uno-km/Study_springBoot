package com.unoSpringBoot.study.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unoSpringBoot.study.DTO.ResponseDTO;

@RestController
@RequestMapping("todo")
public class TodoController {
	@GetMapping("/badConnect")
	public ResponseEntity<?> testControllerResponseEntity() {
		List<String> list = new ArrayList<String>();
		list.add("하위~~~~  내이름은 오류 400이야!! 반가워!!");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.badRequest().body(response);
	}
}
