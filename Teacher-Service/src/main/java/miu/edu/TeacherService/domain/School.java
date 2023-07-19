package miu.edu.TeacherService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.ContactService.domain.Contact;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {
    private  String name;
    private String address;
    private Contact contact;

}
