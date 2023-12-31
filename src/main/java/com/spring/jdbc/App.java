package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program started!" );
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        // insert
//        String insertQuery = "insert into student(id, name, city) values(?,?,?)";

        // fire query

        StudentDao studentDao = context.getBean("studentDao", StudentDaoImpl.class);
//        Student student = new Student(333,"Sumit G","Pune");
//        System.out.println("Number of records inserted : "+ studentDao.insert(student));

        // update operation
        Student student1 = new Student(333, "Sumit Gopalghare", "Kharda");
        System.out.println("Number of records updated : "+studentDao.modify(student1));

        // delete operation
//        System.out.println("Number of rows selected : "+ studentDao.delete(222));

        // select one student
        System.out.println("Number of rows selected : "+ studentDao.getStudent(222));

        // select all students
        List<Student> students = studentDao.getAllStudents();
        for (Student studentfromList : students) {
            System.out.println(studentfromList);
        }
    }
}
