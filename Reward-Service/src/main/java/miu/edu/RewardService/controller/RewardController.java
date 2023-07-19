package miu.edu.RewardService.controller;

import miu.edu.RewardService.dto.RewardDto;
import miu.edu.RewardService.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rewards")
public class RewardController {
    @Autowired
    RewardService rewardService;
    @PostMapping
    public ResponseEntity<?> add(@RequestBody  RewardDto rewardDto) throws Exception{
       RewardDto savedRewardDto = rewardService.add(rewardDto);
       return new ResponseEntity<>(savedRewardDto, HttpStatus.CREATED);
    }
    @GetMapping("/rewardName/{name}")
    public ResponseEntity<?> getRewardByName(@PathVariable String name) {
        RewardDto savedRewardDto = rewardService.findByName(name);
        return new ResponseEntity<>(savedRewardDto, HttpStatus.OK);
    }
    @GetMapping("/{rewardId}")
   public ResponseEntity<?> view(@PathVariable String rewardId) {
        RewardDto savedRewardDto = rewardService.view(rewardId);
        return new ResponseEntity<>(savedRewardDto, HttpStatus.OK);
    }

    @GetMapping
    public   ResponseEntity< List<RewardDto>> viewAll(){
        List<RewardDto> rewardDtoList = rewardService.viewAll();
        return  new ResponseEntity<>(rewardDtoList,HttpStatus.OK);
    }
    @PutMapping(("/{rewardId}"))
    public ResponseEntity<?> update(@PathVariable String rewardId, @RequestBody RewardDto  rewardDto) throws Exception{
        RewardDto savedRewardDto =rewardService.update(rewardId,rewardDto);
        return new ResponseEntity<>(savedRewardDto, HttpStatusCode.valueOf(200));
    }
@DeleteMapping("/{rewardId}")

   public ResponseEntity<Void> remove(@PathVariable String rewardId){
        rewardService.remove(rewardId);
        return  new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }
}
