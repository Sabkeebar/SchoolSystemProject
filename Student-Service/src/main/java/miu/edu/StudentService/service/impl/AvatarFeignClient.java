package miu.edu.StudentService.service.impl;

import miu.edu.Avatarservice.dto.AvatarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("AVATAR-SERVICE")
public interface AvatarFeignClient {
    @GetMapping("api/v1/avatars/{avatarId}")
    public ResponseEntity<AvatarDto> view(@PathVariable String avatarId);

}
