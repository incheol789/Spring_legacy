package com.sh.spring.todo.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
	
	private int no;
	private String todo;
	private LocalDateTime createdAt;
	private LocalDateTime completedAt;
}
