package com.unoSpringBoot.study.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unoSpringBoot.study.DTO.testDTO;
import com.unoSpringBoot.study.mapper.testMapper;

@RestController
public class test {
	@Autowired
	testMapper testMapper;

	@GetMapping("/main")
	public List<testDTO> getList() {
		List<testDTO> list = testMapper.getList();
		return list;
	}
}
