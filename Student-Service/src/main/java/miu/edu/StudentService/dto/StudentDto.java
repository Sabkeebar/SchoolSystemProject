package miu.edu.StudentService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.Avatarservice.Domain.Avatar;
import miu.edu.ClassService.dto.Class;
import miu.edu.Elementservice.domain.ElementType;
import miu.edu.RewardService.domain.Reward;
import miu.edu.SchoolService.domain.School;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    private String studentNumber;

    private SchoolDto school;
    private Class studentClass ;
   // private Avatar avatar;
    //private List<Reward> reward;
   private HashMap<ElementType, Double> elementMap;
    private  double score;
}
