package com.unoSpringBoot.study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aPlatformers.mapper.testMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class StudySpringBootApplicationTests {

	@Autowired
	private testMapper testMapper;

	@Test
	public void testGetTime() {
		log.info("testMapper class name: " + testMapper.getList());
	}
}
