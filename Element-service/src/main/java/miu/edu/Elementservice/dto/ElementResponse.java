package miu.edu.Elementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.Elementservice.domain.Element;
import miu.edu.Elementservice.domain.ElementType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElementResponse {
    private String id;
    private ElementType type;
    private double price;
}
