package miu.edu.TeacherService.controller;

import miu.edu.TeacherService.dto.TeacherDto;
import miu.edu.TeacherService.helper.TeacherAdaptor;
import miu.edu.TeacherService.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAuthority('admin')")
    public TeacherDto addTeacher(@RequestBody  TeacherAdaptor teacherAdaptor){
       return teacherService.addTeacher(teacherAdaptor);
    }
    @GetMapping("/{teacherId}")

    public ResponseEntity<?> viewTeacher(@PathVariable  String teacherId ){
        TeacherDto teacherDto =teacherService.viewTeacher(teacherId);
        return new ResponseEntity<>(teacherDto,HttpStatus.OK) ;

    }
    @GetMapping()
    public ResponseEntity< List<TeacherDto>> viewTeachers () {
        List<TeacherDto> teacherDtos = teacherService.viewTeachers();
        return  ResponseEntity.ok(teacherDtos);
    }
    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable  String teacherId,@RequestBody  TeacherAdaptor teacherAdaptor){
        TeacherDto teacherDto1 = teacherService.updateTeacher(teacherId,teacherAdaptor );
        return  new ResponseEntity<>(teacherDto1, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("/{teacherId}")
   public ResponseEntity <Void >removeTeacher(@PathVariable  String teacherId){
        teacherService.removeTeacher(teacherId);
     return ResponseEntity.noContent().build();
   }


}
