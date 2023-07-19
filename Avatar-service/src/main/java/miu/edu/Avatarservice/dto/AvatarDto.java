package miu.edu.Avatarservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvatarDto {
    private String head;
    private  String  hair;
    private  String   eye;
    private  String  eyebrow;
    private  String   nose;
    private  String   mouth;
    private  String   ears;
    private  String   body;
    private  String   hat;
    private  String   top;
    private  String   topColor;
    private  String   hatColor;
}
