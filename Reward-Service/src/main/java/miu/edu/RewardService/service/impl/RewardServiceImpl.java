package miu.edu.RewardService.service.impl;

import miu.edu.RewardService.domain.Reward;
import miu.edu.RewardService.dto.RewardDto;
import miu.edu.RewardService.helper.RewardType;
import miu.edu.RewardService.repository.RewardRepository;
import miu.edu.RewardService.service.RewardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RewardServiceImpl implements RewardService {

@Autowired
    RewardRepository rewardRepository;
@Autowired
    ModelMapper modelMapper;
    @Override
    public RewardDto add(RewardDto rewardDto) throws Exception {
        if (!(rewardDto.getType() == RewardType.ELEMENT || rewardDto.getType() == RewardType.IN_SCHOOL
                ||rewardDto.getType() == RewardType.GIFT)) {
            throw new Exception("please double check reward Tye !, type hase to either ELEMENT, IN_SCHOOL or GIFT");
            // Code to be executed if the reward type is either ELEMENT or IN_SCHOOL
        }

        Reward reward = modelMapper.map(rewardDto, Reward.class);
        if(reward.getPrice()<25||reward.getPrice()>50){
         throw   new Exception("minimum price  has to 25 and maximum price has to 50");

        }

      Reward savedReward = rewardRepository.save(reward);
        return modelMapper.map(savedReward, RewardDto.class);
    }

    @Override
    public RewardDto view(String rewardId) {
        Reward reward = rewardRepository.findById(rewardId).get();

        return modelMapper.map(reward,RewardDto.class);
    }

    @Override
    public List<RewardDto> viewAll() {
        List<Reward> rewards = rewardRepository.findAll();

        List<RewardDto> rewardDtos = new ArrayList<>();
        for(Reward reward:rewards){
            RewardDto rewardDto =modelMapper.map(reward, RewardDto.class);
            rewardDtos.add(rewardDto);
        }

        return rewardDtos;
    }

    @Override
    public RewardDto update(String rewardId, RewardDto rewardDto) throws Exception {

        Reward savedReward = rewardRepository.findById(rewardId).get();
        Reward reward = modelMapper.map(rewardDto, Reward.class);
        if (!(rewardDto.getType() == RewardType.ELEMENT || rewardDto.getType() == RewardType.IN_SCHOOL
                ||rewardDto.getType() == RewardType.GIFT)) {
            throw new Exception("please double check reward Tye !, type hase to either ELEMENT, IN_SCHOOL or GIFT");
        }
        if(reward.getPrice()<25||reward.getPrice()>50){
           throw  new Exception("minimum price  has to 25 and maximum price has to 50");
        }
        savedReward.setName(reward.getName());
        savedReward.setQuantity(rewardDto.getQuantity());
        savedReward.setType(reward.getType());
        savedReward.setPrice(reward.getPrice());
      Reward reward1=  rewardRepository.save(savedReward);
        return  modelMapper.map(reward,RewardDto.class);
    }


    @Override
    public void remove(String rewardId) {
       rewardRepository.deleteById(rewardId);
    }

    @Override
    public RewardDto findByName(String name) {
       return modelMapper.map( rewardRepository.findByName(name), RewardDto.class);

    }
}
