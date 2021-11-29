package com.unoSpringBoot.study.DTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ResponseVO {
	String name = "김은호";
	int age = 24;
}
