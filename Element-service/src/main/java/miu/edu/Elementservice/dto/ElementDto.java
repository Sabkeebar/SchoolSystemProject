package miu.edu.Elementservice.dto;


import  miu.edu.Elementservice.domain.Element;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.Elementservice.domain.ElementType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElementDto {
    private ElementType type;
    private double price;
}
