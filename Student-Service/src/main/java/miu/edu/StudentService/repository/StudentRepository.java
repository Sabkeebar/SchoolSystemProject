package miu.edu.StudentService.repository;

import miu.edu.StudentService.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {

}
