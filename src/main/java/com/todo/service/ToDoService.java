package com.todo.service;

import java.util.List;

import com.todo.dto.Student;

public interface ToDoService {

	public String add(Student student);

	public String delete(int id);

	public List<Student> getToDoList();
}
