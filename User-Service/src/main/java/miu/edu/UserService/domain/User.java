package miu.edu.UserService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(value = "users")
public class User {
   private String username;

   private String password;
   private  String role;
}
