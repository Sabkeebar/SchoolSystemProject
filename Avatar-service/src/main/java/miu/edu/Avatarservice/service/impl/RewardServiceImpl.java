package miu.edu.Avatarservice.service.impl;

import miu.edu.Avatarservice.Domain.Avatar;
import miu.edu.Avatarservice.dto.AvatarDto;
import miu.edu.Avatarservice.repository.AvatarRepository;
import miu.edu.Avatarservice.service.AvatarService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RewardServiceImpl implements AvatarService {

@Autowired
    AvatarRepository avatarRepository;
@Autowired
    ModelMapper modelMapper;

    @Override
    public AvatarDto add(AvatarDto avatarDto) {
        Avatar avatar = modelMapper.map(avatarDto, Avatar.class);
      Avatar savedAvatar =  avatarRepository.save(avatar);
        return modelMapper.map(savedAvatar, AvatarDto.class);
    }

    @Override
    public AvatarDto view(String avatarId) {
        Avatar avatar = avatarRepository.findById(avatarId).get();
        return modelMapper.map(avatar, AvatarDto.class);
    }

    @Override
    public List<AvatarDto> viewAll() {
        List<Avatar> avatars = avatarRepository.findAll();
        List<AvatarDto> avatarDtos = new ArrayList<>();
        for(Avatar avatar:avatars){
            AvatarDto avatarDto =modelMapper.map(avatar, AvatarDto.class);
            avatarDtos.add(avatarDto);

        }
        return avatarDtos;
    }

    @Override
    public AvatarDto update(String avatarId, AvatarDto avatarDto)  {
        Avatar savedAvatar = avatarRepository.findById(avatarId).get();
      savedAvatar.setHead(avatarDto.getHead());
      savedAvatar.setHair(avatarDto.getHair());
      savedAvatar.setEye(avatarDto.getEye());
      savedAvatar.setEyebrow(avatarDto.getEyebrow());
      savedAvatar.setNose(avatarDto.getNose());
      savedAvatar.setMouth(avatarDto.getMouth());
      savedAvatar.setEars(avatarDto.getEars());
      savedAvatar.setBody(avatarDto.getBody());
      savedAvatar.setHat(avatarDto.getHat());
      savedAvatar.setTop(avatarDto.getTop());
      savedAvatar.setTopColor(avatarDto.getTopColor());
      savedAvatar.setHatColor(avatarDto.getHatColor());


      avatarRepository.save(savedAvatar);

        return modelMapper.map(savedAvatar, AvatarDto.class);
    }

    @Override
    public void remove(String avatarId) {
    avatarRepository.deleteById(avatarId);
    }
}
