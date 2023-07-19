package miu.edu.TeacherService.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.ContactService.domain.Contact;
import miu.edu.TeacherService.domain.School;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherAdaptor {
    private  String teacherId;
    private String firstName;
    private String lastName;
    private  String email;
    private  String phone;
    private String schoolId;
    private String  year;
    private  String group;
    private  String userName;
    private  String password;
    private  String role;

}
