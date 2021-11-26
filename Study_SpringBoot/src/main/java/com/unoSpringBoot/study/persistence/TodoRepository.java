package com.unoSpringBoot.study.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unoSpringBoot.study.model.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
	List<TodoEntity> findByUserId(String userId);

	@Query("select * from Todo t where t.userId = ?1")
	List<TodoEntity> findByUser2(String userId);

}
