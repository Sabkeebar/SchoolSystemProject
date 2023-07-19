package miu.edu.RewardService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.RewardService.helper.RewardType;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardDto {

    private String name;
    private  int quantity;
    private RewardType type;
    private double price;
}
