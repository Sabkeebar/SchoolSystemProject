package miu.edu.Elementservice.repository;

import miu.edu.Elementservice.domain.Element;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ElementRepository extends MongoRepository<Element, String> {
}
