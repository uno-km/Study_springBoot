package com.unoSpringBoot.study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}