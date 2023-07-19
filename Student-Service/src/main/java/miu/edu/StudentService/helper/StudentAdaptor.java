package miu.edu.StudentService.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAdaptor {
    private  String studentId;
    private String firstName;
    private String lastName;
    private String studentNumber;

    private  String score;
    private  String userName;
    private  String password;
    private  String role;
    private String schoolId;

    private String  year;
    private  String group;
    private  String avatarId;
    private  String rewardName;
}
