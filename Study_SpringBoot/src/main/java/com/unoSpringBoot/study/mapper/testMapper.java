package com.unoSpringBoot.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.unoSpringBoot.study.DTO.testDTO;

@Mapper
public interface testMapper {

	public List<testDTO> getList();
}