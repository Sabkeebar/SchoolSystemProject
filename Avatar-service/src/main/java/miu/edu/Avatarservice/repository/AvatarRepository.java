package miu.edu.Avatarservice.repository;

import miu.edu.Avatarservice.Domain.Avatar;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvatarRepository extends MongoRepository<Avatar,String> {

}
