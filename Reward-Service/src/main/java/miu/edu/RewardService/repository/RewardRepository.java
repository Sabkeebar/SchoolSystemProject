package miu.edu.RewardService.repository;

import miu.edu.RewardService.domain.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RewardRepository extends MongoRepository<Reward,String> {
    Reward findByName(String name);

}
