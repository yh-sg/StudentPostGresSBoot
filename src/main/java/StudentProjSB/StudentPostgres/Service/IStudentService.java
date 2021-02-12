package StudentProjSB.StudentPostgres.Service;

import java.util.List;

import StudentProjSB.StudentPostgres.Model.Student;


public interface IStudentService {
	List<Student> getAllStudent();
	Student getOneStudent(Long id);
	void postStudent(Student student);
	Student updateStudent(Long id, Student student);
	void deleteStudent(Long id);
}
