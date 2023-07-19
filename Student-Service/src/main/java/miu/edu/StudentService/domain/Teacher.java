package miu.edu.StudentService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.ClassService.dto.Class;
import miu.edu.ContactService.domain.Contact;
import miu.edu.SchoolService.domain.School;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Teacher {
    @Id
    private  String teacherId;
    private String firstName;
    private String lastName;
    private Contact contact;
    private School school;
    private Class teachingClass;




}
