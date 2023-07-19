package miu.edu.Elementservice.service;


import miu.edu.Elementservice.domain.Element;
import miu.edu.Elementservice.dto.ElementDto;
import miu.edu.Elementservice.dto.ElementResponse;
import miu.edu.Elementservice.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementService {
    @Autowired
    private ElementRepository elementRepository;
    public void createElement(ElementDto elementDto) {
       Element element=  Element.builder()
                .type(elementDto.getType())
                .price(elementDto.getPrice())
                .build();
       elementRepository.save(element);
    }

    public ElementResponse getElementById(String id) {
    Element element= elementRepository.findById(id).get();
   return ElementResponse.builder()
            .id(element.getId())
            .type(element.getType())
            .price(element.getPrice())
            .build();

    }


    public List<ElementResponse> getAllElements() {
        List<Element> elements = elementRepository.findAll();
       return  elements.stream().map(element -> mapToElementResponse(element)).toList();
    }

    private ElementResponse mapToElementResponse(Element element) {
        return ElementResponse.builder()
                .id(element.getId())
                .type(element.getType())
                .price(element.getPrice())
                .build();
    }

    public void updateElement(ElementDto elementDto, String id) {
        Element element = elementRepository.findById(id).get();
        element.setType(elementDto.getType());
        element.setPrice(elementDto.getPrice());
        elementRepository.save(element);

    }


    public void removeElement(String id) {
        elementRepository.deleteById(id);
    }

}
