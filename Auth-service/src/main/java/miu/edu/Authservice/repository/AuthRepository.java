package miu.edu.Authservice.repository;

import miu.edu.UserService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthRepository  extends MongoRepository<User,String> {
    User findByUsername(String username);
}
