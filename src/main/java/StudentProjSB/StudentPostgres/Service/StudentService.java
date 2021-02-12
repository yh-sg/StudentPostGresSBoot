package StudentProjSB.StudentPostgres.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StudentProjSB.StudentPostgres.DAO.StudentRepository;
import StudentProjSB.StudentPostgres.Model.Student;

@Service
public class StudentService implements IStudentService{
	
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
	
	@Override
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	@Override
	public Student getOneStudent(Long id) {
		Optional<Student> findOneStudent = studentRepository.findById(id);
		if(findOneStudent.isEmpty()) {
			throw new IllegalStateException("No such student id: " + id);
		}
		return findOneStudent.get();
	}
	
	@Override
	public void postStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);
	}
	
	@Override
	public void deleteStudent(Long id) {
		boolean exists = studentRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("No such student id: " + id);
		}
		studentRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Student updateStudent(Long id, Student student) {
		Optional<Student> result = studentRepository.findById(id);
		if(result.isEmpty()) {
			throw new IllegalStateException("No such student id: " + id);
		}
		System.out.println("===============");
		System.out.println(result);
		System.out.println("===============");
		Student updatedStudent = result.get();
		System.out.println("===============");
		System.out.println(updatedStudent);
		System.out.println("===============");
		
		updatedStudent.setName(student.getName());

		updatedStudent.setEmail(student.getEmail());
		
		return studentRepository.save(updatedStudent);
	}
}
