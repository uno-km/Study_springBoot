package com.aPlatformers.DTO;

import com.aPlatformers.model.TodoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
	private String id;
	private String title;
	private boolean done;

	public TodoDTO(final TodoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}

	public static TodoEntity setEntity(final TodoDTO dto) {
		return TodoEntity.builder().id(dto.getId())
				.title(dto.getTitle()).done(dto.isDone())
				.build();
	}
}
