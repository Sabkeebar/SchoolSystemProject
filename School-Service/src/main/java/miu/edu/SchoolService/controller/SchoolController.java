package miu.edu.SchoolService.controller;

import miu.edu.SchoolService.adaptor.SchoolAdaptor;
import miu.edu.SchoolService.dto.SchoolDto;
import miu.edu.SchoolService.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/schools")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolDto createSchool(@RequestBody SchoolAdaptor schoolAdaptor) {
        return schoolService.createSchool(schoolAdaptor);
    }

    @GetMapping("/{schoolId}")
    @ResponseStatus(HttpStatus.OK)
    public SchoolDto getSchool(@PathVariable String schoolId) {
        return schoolService.getSchool(schoolId);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolDto> getAllSchool() {
        return schoolService.getAllSchool();
    }

    @PutMapping("/{schoolId}")

    @ResponseStatus(HttpStatus.OK)
    public SchoolDto updateSchool(@PathVariable String schoolId, @RequestBody SchoolAdaptor schoolAdaptor) {
        return schoolService.updateSchool(schoolId, schoolAdaptor);
    }

    @DeleteMapping("/{schoolId}")
    public ResponseEntity<String> DeleteSchool(@PathVariable String schoolId) {
        schoolService.deleteSchool(schoolId);

        return new ResponseEntity<String>("success fully deleted", HttpStatusCode.valueOf(204));
    }
}
