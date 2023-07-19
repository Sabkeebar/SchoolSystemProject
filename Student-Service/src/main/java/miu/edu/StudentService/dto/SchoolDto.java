package miu.edu.StudentService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.ContactService.domain.Contact;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolDto {
//private  String schoolId;
    private  String name;
    private String address;
    private Contact contact;
}
