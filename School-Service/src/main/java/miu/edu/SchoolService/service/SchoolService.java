package miu.edu.SchoolService.service;

import miu.edu.SchoolService.adaptor.SchoolAdaptor;
import miu.edu.SchoolService.dto.SchoolDto;

import java.util.List;

public interface SchoolService {
    public SchoolDto createSchool(SchoolAdaptor schoolAdaptor);

    public SchoolDto getSchool(String schoolIs);
    public List<SchoolDto> getAllSchool();
    public SchoolDto updateSchool(String schoolIs, SchoolAdaptor schoolAdaptor);
    public void deleteSchool(String schoolIs);
}
