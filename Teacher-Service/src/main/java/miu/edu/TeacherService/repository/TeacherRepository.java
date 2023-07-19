package miu.edu.TeacherService.repository;

import miu.edu.TeacherService.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository  extends MongoRepository<Teacher, String> {
}
