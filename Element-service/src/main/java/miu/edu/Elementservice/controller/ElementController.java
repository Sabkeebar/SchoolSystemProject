package miu.edu.Elementservice.controller;


import miu.edu.Elementservice.dto.ElementDto;
import miu.edu.Elementservice.dto.ElementResponse;
import miu.edu.Elementservice.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/elements")
public class ElementController {
    @Autowired
    private ElementService elementService;
    @PostMapping
    public void create(@RequestBody ElementDto elementDto){
        elementService.createElement(elementDto);
    }

    @GetMapping("/{elementId}")
    public ElementResponse getElementById(@PathVariable String elementId ){
        return elementService.getElementById(elementId);
    }
    @GetMapping
    public List<ElementResponse> getAll(){
        return elementService.getAllElements();
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody ElementDto elementDto, @PathVariable String id){
           elementService.updateElement(elementDto, id);
    }
    @DeleteMapping("/remove/{id}")
    private void deleteElement(@PathVariable String id){
        elementService.removeElement(id);
    }

}
