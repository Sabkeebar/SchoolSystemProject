package miu.edu.TeacherService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.ClassService.dto.Class;
import miu.edu.ContactService.domain.Contact;
import miu.edu.TeacherService.domain.School;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TeacherDto {
    private String firstName;
    private String lastName;
    private Contact contact;
    private Class teachingClass;
    private School school;

}
