package StudentProjSB.StudentPostgres.Controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import StudentProjSB.StudentPostgres.Model.Student;

@RestController
public class StudentController {
	
	@GetMapping
	public List<Student> hello() {
		return List.of(
				new Student(
						1L,
						"John",
						"John.Doe@123.com",
						LocalDate.of(2001, Month.FEBRUARY, 4),
						21
						)
				);
	}
	
}
