package com.todo.dao;

import java.util.List;

import com.todo.dto.Student;

public interface ToDoDao {

	public int add(Student student);
	
	public int delete(int id);
	
	public List<Student> getToDoList();
}
