package com.todo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.todo.common.Utilities;
import com.todo.dao.ToDoDao;
import com.todo.dto.Student;

@Repository
public class ToDoDaoImpl implements ToDoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int add(Student student) {

		int no = 0;
		try {
			String sql = "INSERT INTO todo(id, name, marks) VALUES(?, ?, ?)";

			no = jdbcTemplate.update(sql, Utilities.generateRandom(4), student.getName(), student.getMarks());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return no;
	}

	@Override
	public int delete(int id) {

		int no = 0;

		try {
			String sql = "DELETE FROM todo WHERE id=?";
			no = jdbcTemplate.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return no;
	}

	@Override
	public List<Student> getToDoList() {

		List<Student> studentList = null;

		try {
			String sql = "SELECT id, name, marks FROM todo";
			studentList = jdbcTemplate.query(sql, new RowMapper<Student>() {

				@Override
				public Student mapRow(ResultSet rs, int no) throws SQLException {

					Student st = new Student();
					st.setId(rs.getInt("id"));
					st.setName(rs.getString("name"));
					st.setMarks(rs.getInt("marks"));

					return st;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentList;
	}

}
