package miu.edu.StudentService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.Avatarservice.Domain.Avatar;
import miu.edu.ClassService.dto.Class;
import miu.edu.Elementservice.domain.ElementType;
import miu.edu.RewardService.domain.Reward;
import miu.edu.RewardService.helper.RewardType;
import miu.edu.SchoolService.domain.School;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private  String studentId;
    private String firstName;
    private String lastName;
    private String studentNumber;
    private double score = 1000;
    private School school;
    private Class studentClass ;
    private Avatar avatar;
    private HashMap<RewardType,Reward> rewardMap;
    private HashMap<ElementType, Double> elementMap ;


}
