package miu.edu.UserService.repository;

import miu.edu.UserService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface
UserRepository extends MongoRepository<User,Long> {
    User findByUsername(String name);
}
