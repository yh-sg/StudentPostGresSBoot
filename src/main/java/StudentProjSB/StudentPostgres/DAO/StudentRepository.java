package StudentProjSB.StudentPostgres.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import StudentProjSB.StudentPostgres.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	
}
