package miu.edu.Avatarservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.Elementservice.domain.Element;
import miu.edu.Elementservice.domain.ElementType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avatar {
    @Id
    private String avatarId;

   private String head;
    private String hair;
    private String eye;
    private String  eyebrow;
    private String  nose;
    private String mouth;
    private String  ears;
    private String   body;
    private String hat;
    private  String  top;
    private String  topColor;
    private String  hatColor;

}
