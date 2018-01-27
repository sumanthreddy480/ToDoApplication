package com.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.todo.dto.Student;
import com.todo.service.ToDoService;

@Controller
public class ToDoController {

	private final Logger logger = LoggerFactory.getLogger(ToDoController.class);

	@Autowired
	private ToDoService toDoService;

	@RequestMapping(value = "/getform", method = RequestMethod.GET)
	public ModelAndView showform() {
		return new ModelAndView("/save");
	}

	@RequestMapping(value = "/todolist", method = RequestMethod.GET)
	public ModelAndView todoList(HttpServletRequest request) {
		
		logger.info("ToDoController.todoList(), List student details:");
		
		List<Student> list = toDoService.getToDoList();

		String status = request.getParameter("status");
		request.setAttribute("status", status);
		request.setAttribute("todoList", list);
		return new ModelAndView("/todolist");
	}

	@RequestMapping(value = "/savetodo", method = RequestMethod.POST)
	public ModelAndView save(Student student, HttpServletRequest request) {
		logger.info("ToDoController.save(), Creating student details:");

		String status = toDoService.add(student);

		return new ModelAndView("redirect:/todolist", "status", status);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
		logger.info("ToDoController.delete(), deleting student details:");

		String status = toDoService.delete(id);

		return new ModelAndView("redirect:/todolist", "status", status);
	}

}
