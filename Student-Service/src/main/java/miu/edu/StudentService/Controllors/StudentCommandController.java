package miu.edu.StudentService.Controllors;

import miu.edu.StudentService.dto.StudentDto;
import miu.edu.StudentService.helper.StudentAdaptor;
import miu.edu.StudentService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentCommandController {
    @Autowired
    StudentService studentService;


@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public StudentDto add( @RequestBody StudentAdaptor studentAdaptor){
    return studentService.add(studentAdaptor);
}

@GetMapping("/buy/{studentId}/{elementId}")
    public  String buyElement(@PathVariable String studentId, @PathVariable String elementId){
  return studentService.buyElement(studentId,elementId);
    }
    @GetMapping("/reward/{studentId}/{rewardName}")
    public String addReward(@PathVariable String studentId, @PathVariable String rewardName){
      return  studentService.addReward(studentId,rewardName);
    }
@GetMapping("/{studentId}")
    public StudentDto view(@PathVariable String studentId){
    return studentService.view(studentId);
    }





@GetMapping
@ResponseStatus(HttpStatus.OK)
    public List<StudentDto> viewAll(){
   return  studentService.viewAll();
    }
    @DeleteMapping("/{studentId}")
    public void remove  (@PathVariable String studentId){
    studentService.remove(studentId);

    }
}
