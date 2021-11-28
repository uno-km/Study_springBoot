package com.unoSpringBoot.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.UnoDOC.Validate;
import com.unoSpringBoot.study.model.TodoEntity;
import com.unoSpringBoot.study.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public String testService() {
		TodoEntity todoEntity = TodoEntity.builder().title("하위~").userId("KimEunHo").build();
		todoRepository.save(todoEntity);
		TodoEntity saveEntity = todoRepository.findById(todoEntity.getId()).get();
		return saveEntity.getUserId();
	}

	public List<TodoEntity> retrieveTodo(final String userId) {
		log.info("entity id : {} is saved", userId);
		return todoRepository.findByUserId(userId);
	}

	public List<TodoEntity> createTodo(final TodoEntity entity) {
		Validate.checkValidate(entity);
		todoRepository.save(entity);
		log.info("entity id : {} is saved", entity.getUserId());
		return todoRepository.findByUserId(entity.getUserId());
	}

	public List<TodoEntity> updateTodo(final TodoEntity entity) {
		// 저장할 엔티티가 유효한지 확인한다.
		Validate.checkValidate(entity);
		// 넘겨받은 엔티티 id를 이용해 Todo Entity를 가져온다. 존재하지 않은 엔티티는 업데이트 할 수 없기때문
		final Optional<TodoEntity> original = todoRepository.findById(entity.getId());
		original.ifPresent(todo -> {
		// 반환된 투두엔티티가 존재하면 값을 새 엔티티값으로 덮어씌운다.
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
		// 데이터베이스에 새 값을 저장한다.
			todoRepository.save(todo);
		});
		// 리스트를 보여주는 메서드를 반환해 사용자의 모든 todo리스트로 리턴하게 한다.
		return retrieveTodo(entity.getUserId());

	}
}
