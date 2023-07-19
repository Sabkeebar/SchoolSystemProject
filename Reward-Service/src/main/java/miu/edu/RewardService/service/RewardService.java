package miu.edu.RewardService.service;

import miu.edu.RewardService.domain.Reward;
import miu.edu.RewardService.dto.RewardDto;

import java.util.List;

public interface RewardService  {
    public RewardDto add(RewardDto rewardDto) throws Exception;
    public RewardDto view(String rewardId);
    public List<RewardDto> viewAll();
    public RewardDto update(String rewardId,RewardDto  rewardDto) throws Exception;
    public void remove(String rewardId);
    RewardDto findByName(String name);
}
