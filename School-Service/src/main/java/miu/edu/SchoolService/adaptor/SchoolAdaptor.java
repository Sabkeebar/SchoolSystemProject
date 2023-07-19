package miu.edu.SchoolService.adaptor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.ContactService.domain.Contact;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolAdaptor {
    private  String name;
    private String address;
    private Contact contact;
    private  String email;
    private  String phone;
}
