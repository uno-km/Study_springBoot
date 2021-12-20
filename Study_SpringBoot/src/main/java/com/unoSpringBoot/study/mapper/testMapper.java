package com.unoSpringBoot.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface testMapper {

	@Select("select sysdate from dual")
	public String getTime();
}