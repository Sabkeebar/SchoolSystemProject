package miu.edu.TeacherService.service;

import miu.edu.TeacherService.dto.TeacherDto;
import miu.edu.TeacherService.helper.TeacherAdaptor;

import java.util.List;

public interface TeacherService {
   public TeacherDto addTeacher(TeacherAdaptor teacherAdaptor);
   public TeacherDto viewTeacher(String teacherId );
   public List<TeacherDto> viewTeachers ();
   public TeacherDto updateTeacher(String teacherId,TeacherAdaptor teacherAdaptor);
    public  void removeTeacher(String teacherId);

}
