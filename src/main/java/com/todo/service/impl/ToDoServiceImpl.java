package com.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.dao.ToDoDao;
import com.todo.dto.Student;
import com.todo.service.ToDoService;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private ToDoDao toDoDao;

	@Override
	public String add(Student student) {

		String returnValue = "";

		int result = toDoDao.add(student);

		if (result == 1) {
			returnValue = "SUCCESS";
		} else {
			returnValue = "FAILED";
		}

		return returnValue;
	}

	@Override
	public String delete(int id) {

		String returnValue = "";

		int result = toDoDao.delete(id);

		if (result == 1) {
			returnValue = "SUCCESS";
		} else {
			returnValue = "FAILED";
		}

		return returnValue;
	}

	@Override
	public List<Student> getToDoList() {

		return toDoDao.getToDoList();
	}

}
