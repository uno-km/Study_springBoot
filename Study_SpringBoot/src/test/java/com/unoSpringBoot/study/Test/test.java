package com.unoSpringBoot.study.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unoSpringBoot.study.mapper.testMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class test {

	@Autowired
	private testMapper testMapper;

	@Test
	public void testGetTime() {
		log.info("testMapper class name: " + testMapper.getClass().getName());
		log.info("testMapper time: " + testMapper.getTime());
	}
}