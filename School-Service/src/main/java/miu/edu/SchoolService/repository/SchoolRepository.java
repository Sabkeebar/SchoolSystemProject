package miu.edu.SchoolService.repository;

import miu.edu.SchoolService.domain.School;;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchoolRepository  extends MongoRepository<School,String> {

}
