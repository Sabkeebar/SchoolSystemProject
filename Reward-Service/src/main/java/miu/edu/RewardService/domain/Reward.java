package miu.edu.RewardService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.RewardService.helper.RewardType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reward {
    @Id
    private  String reviewId;
   private String name;
   private  int quantity;
    private RewardType type;
    private double price;
}
