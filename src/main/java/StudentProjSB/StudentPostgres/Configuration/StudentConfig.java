package StudentProjSB.StudentPostgres.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import StudentProjSB.StudentPostgres.DAO.StudentRepository;
import StudentProjSB.StudentPostgres.Model.Student;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student john = new Student(
					"John",
					"John.Doe@123.com",
					LocalDate.of(2001, Month.FEBRUARY, 4),
					21
				);
			
			Student mary = new Student(
					"Mary",
					"Mary.Doe@123.com",
					LocalDate.of(2000, Month.FEBRUARY, 4),
					22
				);
			
			repository.saveAll(
					List.of(john, mary)
					);
		};
	}
}
