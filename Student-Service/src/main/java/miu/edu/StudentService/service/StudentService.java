package miu.edu.StudentService.service;

import miu.edu.Elementservice.domain.Element;
import miu.edu.StudentService.dto.StudentDto;
import miu.edu.StudentService.helper.StudentAdaptor;

import java.util.List;

public interface StudentService {
    public StudentDto add(StudentAdaptor studentAdaptor);
    public StudentDto  view(String studentId);
    public List<StudentDto> viewAll();
    public StudentDto  updateStudent(String studentId,StudentAdaptor studentAdaptor);
    public void remove  (String studentId);
    public  String buyElement(String studentId,String elementId);


}
