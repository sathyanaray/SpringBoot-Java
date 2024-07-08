package com.sathya.SpringJDBC;

import com.sathya.SpringJDBC.model.Student;
import com.sathya.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;
@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		Student s = context.getBean(Student.class);
		s.setRollNo(126);
		s.setName("Sathya");
		s.setMarks(88);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);
		List<Student> students=service.getStudents();
		System.out.println(students);
	}

}
