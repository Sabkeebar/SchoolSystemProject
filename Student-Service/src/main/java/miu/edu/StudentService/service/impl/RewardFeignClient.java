package miu.edu.StudentService.service.impl;

import miu.edu.RewardService.dto.RewardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("REWARD-SERVICE")
public interface RewardFeignClient {
   // @GetMapping("/rewardName/{name}")
    public ResponseEntity<RewardDto> getRewardByName(@PathVariable String name);

}
