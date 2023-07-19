package miu.edu.Avatarservice.controller;

import miu.edu.Avatarservice.dto.AvatarDto;
import miu.edu.Avatarservice.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/avatars")
public class AvatarController {
    @Autowired
    AvatarService avatarService;
    @PostMapping
    public ResponseEntity<AvatarDto> add(@RequestBody AvatarDto  avatarDto) {
        AvatarDto savedAvatarDto =avatarService.add(avatarDto);
        return new ResponseEntity<>(savedAvatarDto, HttpStatusCode.valueOf(201));
    }
    @GetMapping("/{avatarId}")
   public  ResponseEntity<AvatarDto>  view(@PathVariable  String avatarId){
       AvatarDto avatarDto= avatarService.view(avatarId);
       return new ResponseEntity<>(avatarDto, HttpStatus.OK);
   }
   @GetMapping
    public  ResponseEntity< List<AvatarDto> >viewAll(){
        List<AvatarDto> avatarDtos = avatarService.viewAll();
        return new ResponseEntity<>(avatarDtos,HttpStatus.OK);
    }
    @PutMapping("/{avatarId}")
    public ResponseEntity< AvatarDto >update(@PathVariable String avatarId,@RequestBody AvatarDto avatarDto) {
       AvatarDto savedAvatar = avatarService.update(avatarId,avatarDto);
       return  ResponseEntity.ok(savedAvatar);
    }
    @DeleteMapping("/{avatarId}")
    public ResponseEntity<Void> remove(@PathVariable String avatarId){
        avatarService.remove(avatarId);
        return  ResponseEntity.noContent().build();
    }
}
