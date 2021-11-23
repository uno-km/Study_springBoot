package com.unoSpringBoot.study;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unoSpringBoot.study.DTO.ResponseDTO;
import com.unoSpringBoot.study.DTO.TestRequestBodyDTO;

@RestController
@RequestMapping("test")
public class TestController {
	@GetMapping
	public String testController() {
		return "Hello world";
	}

	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		return "Hello world!! TestGetMapping";
	}

	@GetMapping("/{id}")
	public String testControllerWithPathVariables(@PathVariable(required = false) String id) {
		return "Hello wolrd!! ID = " + id;
	}

	@GetMapping("/testRequestParam")
	public String testControllerRequestParam(@RequestParam(required = false) String id) {
		return "Hello wolrd!! ID = " + id + "하위~~!!";
	}

	@GetMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		return "Hello Wolrd!!!! name " + testRequestBodyDTO.getName() + " 그리고 나이는 " + testRequestBodyDTO.getAge();
	}

	@GetMapping("/testResponseBody")
	public ResponseDTO<String> testControllerResponsBody() {
		List<String> list = new ArrayList<String>();
		list.add("하위~~~~ 내이름은 ");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return response;
	}
}