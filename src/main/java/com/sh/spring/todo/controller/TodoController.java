package com.sh.spring.todo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sh.spring.common.annotation.RunnigTime;
import com.sh.spring.todo.model.dto.Todo;
import com.sh.spring.todo.model.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/todo")
@Slf4j
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	
	@GetMapping("/todoList.do")
	public void todoList(Model model) {
		log.debug("todoService = {}", todoService.getClass());
		List<Todo> todoList = todoService.selectTodoList();
		log.debug("todoList = {}", todoList);
		model.addAttribute("todoList", todoList);
		
	
	}
	
	// insert into todo values (seq_todo_no.nextval, ?, default, default)
	@RunnigTime
	@PostMapping("/insertTodo.do")
	public String insertTodo(Todo todo, RedirectAttributes redirectAttr) {
		
		int result = todoService.insertTodo(todo);
		log.debug("todo = {}", todo);
		
		redirectAttr.addFlashAttribute("msg", "할일을 성공적으로 등록했습니다!");
		
		return "redirect:/todo/todoList.do";
	}
	
	@PostMapping("/updateTodo.do")
	public String updateTodo(@RequestParam int no, @RequestParam boolean isCompleted) {
		
		Map<String, Object> param = new HashMap<>();
		param.put("no", no);
		param.put("isCompleted", isCompleted);
		log.debug("param = {}", param);
		
		int result = todoService.updateTodo(param);
		
		return "redirect:/todo/todoList.do";
	}

}
