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
	private testMapper timeMapper;

	@Test
	public void testGetTime() {
		log.info("timeMapper class name: " + timeMapper.getClass().getName());
		log.info("timeMapper time: " + timeMapper.getTime());
	}
}