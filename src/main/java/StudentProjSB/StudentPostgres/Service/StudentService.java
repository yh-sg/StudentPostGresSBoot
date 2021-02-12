package StudentProjSB.StudentPostgres.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

import StudentProjSB.StudentPostgres.Model.Student;

@Service
public class StudentService {
	public List<Student> students = List.of(
			new Student(1L,
						"John",
						"John.Doe@123.com",
						LocalDate.of(2001, Month.FEBRUARY, 4),
						21),
			new Student(2L,
					"Mary",
					"Mary.Doe@123.com",
					LocalDate.of(2002, Month.FEBRUARY, 4),
					20)
			);
	
	public List<Student> getAllStudent(){
		return students;
	}
}
