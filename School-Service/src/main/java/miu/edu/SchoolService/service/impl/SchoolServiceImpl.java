package miu.edu.SchoolService.service.impl;

import miu.edu.ContactService.domain.Contact;
import miu.edu.SchoolService.adaptor.SchoolAdaptor;
import miu.edu.SchoolService.domain.School;
import miu.edu.SchoolService.dto.SchoolDto;
import miu.edu.SchoolService.repository.SchoolRepository;
import miu.edu.SchoolService.service.SchoolService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public SchoolDto createSchool(SchoolAdaptor schoolAdaptor) {
       School school = modelMapper.map(schoolAdaptor, School.class);
        Contact contact = modelMapper.map(schoolAdaptor, Contact.class);
        school.setContact(contact);
        schoolRepository.save(school);
        SchoolDto savedSchoolDto = modelMapper.map(school,SchoolDto.class);
        System.out.println(savedSchoolDto);
        return savedSchoolDto;
    }

    @Override
    public SchoolDto getSchool(String schoolIs) {
        System.out.println(schoolIs);
      School school =  schoolRepository.findById(schoolIs).get();
        System.out.println(school);
        return modelMapper.map(school,SchoolDto.class);
    }

    @Override
    public List<SchoolDto> getAllSchool() {
        List<School> schools =  schoolRepository.findAll();
        List<SchoolDto> schoolDtos = new ArrayList<>();
        for(School school:schools){
            SchoolDto savedSchoolDto = modelMapper.map(school,SchoolDto.class);
            schoolDtos.add(savedSchoolDto);
        }

        return schoolDtos;
    }

    @Override
    public SchoolDto updateSchool(String schoolIs, SchoolAdaptor schoolAdaptor) {
        School school = modelMapper.map(schoolAdaptor,School.class);
        Contact contact = modelMapper.map(schoolAdaptor, Contact.class);


        School savedSchool =  schoolRepository.findById(schoolIs).get();
        savedSchool.setName(school.getName());
        savedSchool.setAddress(school.getAddress());
        savedSchool.setContact(contact);
       School dbSchool = schoolRepository.save(savedSchool);

        return modelMapper.map(dbSchool, SchoolDto.class);
    }

    @Override
    public void deleteSchool(String schoolIs) {
        schoolRepository.deleteById(schoolIs);

    }
}
