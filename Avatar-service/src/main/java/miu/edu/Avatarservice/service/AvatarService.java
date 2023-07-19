package miu.edu.Avatarservice.service;

import miu.edu.Avatarservice.dto.AvatarDto;


import java.util.List;

public interface AvatarService {
    public AvatarDto add(AvatarDto  avatarDto) ;
    public AvatarDto view(String avatarId);
    public List<AvatarDto> viewAll();
    public AvatarDto update(String avatarId,AvatarDto avatarDto) ;
    public void remove(String avatarId);
}
