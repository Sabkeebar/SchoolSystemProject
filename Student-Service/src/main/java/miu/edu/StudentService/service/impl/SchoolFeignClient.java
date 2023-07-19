package miu.edu.StudentService.service.impl;

import miu.edu.SchoolService.dto.SchoolDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("SCHOOL-SERVICE")
public interface SchoolFeignClient {
    @GetMapping("api/v1/schools/{schoolId}")
    @ResponseStatus(HttpStatus.OK)
    public SchoolDto getSchool(@PathVariable String schoolId) ;
}
