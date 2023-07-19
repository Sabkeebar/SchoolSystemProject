package miu.edu.StudentService.service.impl;

import miu.edu.Elementservice.dto.ElementResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ELEMENT-SERVICE")
public interface ElementFeignClient {
    @GetMapping("api/v1/elements/{elementId}")
    public ElementResponse getElementById(@PathVariable String elementId );

}
