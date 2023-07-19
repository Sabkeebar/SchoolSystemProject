package miu.edu.TeacherService.service.impl;

import miu.edu.ClassService.dto.Class;
import miu.edu.ContactService.domain.Contact;
import miu.edu.TeacherService.domain.School;
import miu.edu.TeacherService.domain.Teacher;
import miu.edu.TeacherService.dto.SchoolDto;
import miu.edu.TeacherService.dto.TeacherDto;

import miu.edu.TeacherService.helper.TeacherAdaptor;
import miu.edu.TeacherService.repository.TeacherRepository;
import miu.edu.TeacherService.service.SchoolFeignClient;
import miu.edu.TeacherService.service.TeacherService;
import miu.edu.UserService.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    SchoolFeignClient feignClient;

    @Autowired
    private KafkaTemplate<String, UserDto> kafkaTemplate;
    @Value("${studentTopic1}")
    private  String topicName;
    private  static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);
    @Override

    public TeacherDto addTeacher(TeacherAdaptor teacherAdaptor) {
       String schoolId = teacherAdaptor.getSchoolId();

        SchoolDto  schoolDto= feignClient.getSchool(schoolId);



      Teacher teacher=  modelMapper.map(teacherAdaptor, Teacher.class);
      School school = modelMapper.map(schoolDto, School.class);
      teacher.setSchool(school);

        // create teacher's contact
        Contact contact = new Contact();
        contact.setEmail(teacherAdaptor.getEmail());
        contact.setPhone(teacherAdaptor.getPhone());
        teacher.setContact(contact);

        // create teacher's teaching Class
        Class teachingClass = new Class();
            teachingClass.setYear(teacherAdaptor.getYear());
            teachingClass.setGroup(teacherAdaptor.getGroup());
            teacher.setTeachingClass(teachingClass);
      Teacher savedTeacher =teacherRepository.save(teacher);


//      to sent userDto to User-service
        UserDto userDto = new UserDto();
       userDto.setUsername(teacherAdaptor.getUserName());
       userDto.setPassword(teacherAdaptor.getPassword());
       userDto.setRole(teacherAdaptor.getRole());
    kafkaTemplate.send("student1Topic",userDto);

   LOGGER.info("sent message :" +userDto);

        return modelMapper.map(savedTeacher, TeacherDto.class);
    }

    @Override
    public TeacherDto viewTeacher(String teacherId) {
        System.out.println(teacherId);
        Teacher teacher = teacherRepository.findById(teacherId).get();
        System.out.println(teacher);
        return modelMapper.map(teacher, TeacherDto.class);
    }

    @Override
    public List<TeacherDto> viewTeachers() {
       List< Teacher >teachers =teacherRepository.findAll();
        List<TeacherDto> teacherDtos = new ArrayList<>();
        for (Teacher teacher:teachers){
            TeacherDto teacherDto = modelMapper.map(teacher, TeacherDto.class);
            teacherDtos.add(teacherDto);
        }
        return teacherDtos;
    }

    @Override
    public TeacherDto updateTeacher(String teacherId, TeacherAdaptor teacherAdaptor) {
        Teacher teacher = teacherRepository.findById(teacherId).get();
        String schoolId = teacherAdaptor.getSchoolId();
        SchoolDto  schoolDto= feignClient.getSchool(schoolId);



        Teacher teacher1=  modelMapper.map(teacherAdaptor, Teacher.class);
        teacher.setFirstName(teacher1.getFirstName());
        teacher.setLastName(teacher1.getLastName());
        School school = modelMapper.map(schoolDto, School.class);
        teacher.setSchool(school);

        // create teacher's contact
        Contact contact = new Contact();
        contact.setEmail(teacherAdaptor.getEmail());
        contact.setPhone(teacherAdaptor.getPhone());
        teacher.setContact(contact);
        Class teachingClass = new Class();
        teachingClass.setYear(teacherAdaptor.getYear());
        teachingClass.setGroup(teacherAdaptor.getGroup());
        teacher.setTeachingClass(teachingClass);
        Teacher savedTeacher =teacherRepository.save(teacher);



        return modelMapper.map(savedTeacher, TeacherDto.class);
    }

    @Override
    public void removeTeacher(String teacherId) {
     teacherRepository.deleteById(teacherId);
    }
}
