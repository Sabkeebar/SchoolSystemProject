package miu.edu.StudentService.service.impl;

import miu.edu.Avatarservice.Domain.Avatar;
import miu.edu.ClassService.dto.Class;
import miu.edu.Elementservice.domain.Element;
import miu.edu.Elementservice.domain.ElementType;
import miu.edu.Elementservice.dto.ElementDto;
import miu.edu.Elementservice.dto.ElementResponse;
import miu.edu.RewardService.domain.Reward;
import miu.edu.RewardService.dto.RewardDto;
import miu.edu.RewardService.helper.RewardType;
import miu.edu.SchoolService.domain.School;
import miu.edu.SchoolService.dto.SchoolDto;
import miu.edu.StudentService.domain.Student;
import miu.edu.StudentService.dto.StudentDto;
import miu.edu.StudentService.helper.StudentAdaptor;
import miu.edu.StudentService.repository.StudentRepository;
import miu.edu.StudentService.service.StudentService;
import miu.edu.UserService.domain.User;
import miu.edu.UserService.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    SchoolFeignClient schoolFeignClient;

    @Autowired
    RewardFeignClient rewardFeignClient;

    @Autowired
    ElementFeignClient elementFeignClient;


    @Value("${studentScore}")
    private double stScore;
    @Autowired
    private KafkaTemplate<String, UserDto> kafkaTemplate;
    Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public StudentDto add(StudentAdaptor studentAdaptor) {
        System.out.println("here");
        LOGGER.info("HERE");
        Student student = modelMapper.map(studentAdaptor, Student.class);
//        create school
        System.out.println(studentAdaptor.getSchoolId());
        SchoolDto schoolDto = schoolFeignClient.getSchool(studentAdaptor.getSchoolId());
        School school = modelMapper.map(schoolDto, School.class);

        //createReward
        // RewardDto rewardDto = rewardFeignClient.getRewardByName(studentAdaptor.getRewardName()).getBody();
        //  Reward reward = modelMapper.map(rewardDto, Reward.class);

        //class
        Class studentClass = new Class();
        studentClass.setYear(studentAdaptor.getYear());
        studentClass.setGroup(studentAdaptor.getGroup());

        Avatar avatar = new Avatar();
        student.setAvatar(avatar);
        HashMap<ElementType, Double> elementMap = new HashMap<>();
        student.setElementMap(elementMap);


        student.setSchool(school);
        // student.setReward();
        List<Reward> rewards = new ArrayList<>();
        // rewards.add(reward);
        // student.setReward(rewards);
        student.setStudentClass(studentClass);
        student.setScore(stScore);
        studentRepository.save(student);


        // Kafka

        UserDto userDto = new UserDto();
        userDto.setUsername(studentAdaptor.getUserName());
        userDto.setPassword(studentAdaptor.getPassword());
        userDto.setRole(studentAdaptor.getRole());

        kafkaTemplate.send("student1Topic", userDto);

        LOGGER.info("sent message :" + userDto);

        //return modelMapper.map(savedTeacher, TeacherDto.class);

        return null;
    }

    @Override
    public StudentDto view(String studentId) {
        Student student = studentRepository.findById(studentId).get();

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> viewAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        //School school =
        for (Student student : students) {
            StudentDto studentDto = modelMapper.map(student, StudentDto.class);
            studentDtos.add(studentDto);
        }
        return studentDtos;
    }

    @Override
    public StudentDto updateStudent(String studentId, StudentAdaptor studentAdaptor) {
        return null;
    }

    @Override
    public void remove(String studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public String buyElement(String studentId, String elementId) {
        Student student = studentRepository.findById(studentId).get();
        ElementResponse elementResponse = elementFeignClient.getElementById(elementId);

        double studentScore = student.getScore();
        //ElementDto elementDto = elementFeignClient.getElementById(elementId).getBody();
        double elementPrice = elementResponse.getPrice();
        if (studentScore < elementPrice) {
            return "sorry you dont have enough score";

        }
        //  check check elementTye in student's avatar
        String elementType = elementResponse.getType().toString();
        Element element = modelMapper.map(elementResponse, Element.class);
        Avatar avatar = student.getAvatar();

        // add element to student's avatar
        //  HEAD, HAIR, EYE, EYEBROW, NOSE, MOUTH, EARS, BODY, HAT, TOP, TOP_COLOUR, HAT_COLOUR
        //HashMap
        HashMap<ElementType, Double> elementMap1 = student.getElementMap();
        if (elementMap1.get(ElementType.valueOf(elementType)) != null) {
            Double existingElementPrice = elementMap1.get(ElementType.valueOf(elementType));


            switch (elementType) {

                case "HEAD" -> avatar.setHead(element.getType().toString());

                case "HAIR" -> avatar.setHair(element.getType().toString());

                case "EYE" -> avatar.setEye(element.getType().toString());

                case "EYEBROW" -> avatar.setEyebrow(element.getType().toString());

                case "NOSE" -> avatar.setNose(element.getType().toString());

                case "MOUTH" -> avatar.setMouth(element.getType().toString());

                case "EARS" -> avatar.setEars(element.getType().toString());

                case "BODY" -> avatar.setBody(element.getType().toString());

                case "HAT" -> avatar.setHat(element.getType().toString());

                case "TOP" -> avatar.setTop(element.getType().toString());

                case "TOP_COLOUR" -> avatar.setTopColor(element.getType().toString());

                case "HAT_COLOUR" -> avatar.setHatColor(element.getType().toString());

            }
            student.setScore(studentScore - elementPrice + existingElementPrice);
            elementMap1.put(ElementType.valueOf(elementType), elementPrice);
            return modelMapper.map(studentRepository.save(student), StudentDto.class).toString();


        } else {
            //avatar.setHead(element.getType().toString());
            switch (elementType) {

                case "HEAD" -> avatar.setHead(element.getType().toString());

                case "HAIR" -> avatar.setHair(element.getType().toString());

                case "EYE" -> avatar.setEye(element.getType().toString());

                case "EYEBROW" -> avatar.setEyebrow(element.getType().toString());

                case "NOSE" -> avatar.setNose(element.getType().toString());

                case "MOUTH" -> avatar.setMouth(element.getType().toString());

                case "EARS" -> avatar.setEars(element.getType().toString());

                case "BODY" -> avatar.setBody(element.getType().toString());

                case "HAT" -> avatar.setHat(element.getType().toString());

                case "TOP" -> avatar.setTop(element.getType().toString());

                case "TOP_COLOUR" -> avatar.setTopColor(element.getType().toString());

                case "HAT_COLOUR" -> avatar.setHatColor(element.getType().toString());

            }
            // remove head

            student.setScore(studentScore - elementPrice);
            elementMap1.put(ElementType.valueOf(elementType), elementPrice);
            student.setAvatar(avatar);
            return modelMapper.map(studentRepository.save(student), StudentDto.class).toString();

        }
    }

    public String addReward(String studentId, String rewardName) {
        Student student = studentRepository.findById(studentId).get();
        RewardDto rewardDto = rewardFeignClient.getRewardByName(rewardName).getBody();
        HashMap<RewardType, Reward> studentRewardMap = student.getRewardMap();
        double studentScore = student.getScore();

        if (studentRewardMap.get(RewardType.valueOf(rewardName)) != null) {
            return "reward already exists";
        } else {
            Reward reward = modelMapper.map(rewardDto, Reward.class);
            if (studentScore < reward.getPrice()) {
                return "sorry you dont have enough score";
            }
            studentRewardMap.put(RewardType.valueOf(rewardName), reward);
            student.setScore(studentScore - reward.getPrice());
            student.setRewardMap(studentRewardMap);
            return modelMapper.map(studentRepository.save(student), StudentDto.class).toString();
        }


    }
}
