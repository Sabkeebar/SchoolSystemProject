package miu.edu.SchoolService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.ContactService.domain.Contact;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class School {
@Id
  private String schoolId;
private  String name;
    private String address;
    private Contact contact;
}
