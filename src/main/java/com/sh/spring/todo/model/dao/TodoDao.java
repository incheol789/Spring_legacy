package com.sh.spring.todo.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sh.spring.todo.model.dto.Todo;

@Mapper
public interface TodoDao {

	List<Todo> selectTodoList();

	int insertTodo(Todo todo);

	int updateTodo(Map<String, Object> param);

}
