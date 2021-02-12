package StudentProjSB.StudentPostgres.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import StudentProjSB.StudentPostgres.Model.Student;
import StudentProjSB.StudentPostgres.Service.StudentService;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
	
	@Autowired
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<Student> allStudents() {
		return studentService.getAllStudent();
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		studentService.postStudent(student);
	}
	
}
