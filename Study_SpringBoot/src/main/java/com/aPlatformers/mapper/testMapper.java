package com.aPlatformers.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aPlatformers.DTO.testDTO;

@Mapper
public interface testMapper {

	public List<testDTO> getList();
}