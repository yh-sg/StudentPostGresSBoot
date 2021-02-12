package StudentProjSB.StudentPostgres.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StudentProjSB.StudentPostgres.DAO.StudentRepository;
import StudentProjSB.StudentPostgres.Model.Student;

@Service
public class StudentService {
	
	@Autowired
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
//	public List<Student> students = List.of(
//			new Student(1L,
//						"John",
//						"John.Doe@123.com",
//						LocalDate.of(2001, Month.FEBRUARY, 4)
//						),
//			new Student(2L,
//					"Mary",
//					"Mary.Doe@123.com",
//					LocalDate.of(2002, Month.FEBRUARY, 4)
//					)
//			);
	
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
//	public Student getOneStudent(Long id) {
//		
//	}
	
	public void postStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);
	}
}
