package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        // insert
        String insertQuery = "insert into student(id, name, city) values(?,?,?)";
        int update = this.jdbcTemplate.update(insertQuery, student.getId(), student.getName(), student.getCity());
        return update;
    }

    @Override
    public int modify(Student student) {
        // updating data
        String updateQuery = "update student set name = ?, city = ? where id = ?";
        int update = this.jdbcTemplate.update(updateQuery, student.getName(), student.getCity(), student.getId());
        return update;

    }

    @Override
    public int delete(int studentId) {
        // delete operation
        String deleteQuery = "delete from student where id = ?";
        int update = this.jdbcTemplate.update(deleteQuery, studentId);
        return update;
    }

    @Override
    public Student getStudent(int id) {
        // selecting single student data
        String selectQuery = "select * from student where id = ?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(selectQuery, rowMapper, id);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        // selecting all students
        String selectAllQuery = "select * from student";
        List output = this.jdbcTemplate.query(selectAllQuery, new RowMapperImpl());
        return output;
    }
}
