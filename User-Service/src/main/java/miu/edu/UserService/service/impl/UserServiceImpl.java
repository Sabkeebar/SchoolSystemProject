package miu.edu.UserService.service.impl;

import miu.edu.UserService.domain.User;
import miu.edu.UserService.dto.UserDto;
import miu.edu.UserService.repository.UserRepository;
import miu.edu.UserService.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @KafkaListener(topics = {"student1Topic","teacher1Topic"},groupId = "studentGroup1")
    public void createUser(@Payload UserDto userDto) {
        String password =userDto.getPassword();
        String bcryptPasword =bCryptPasswordEncoder.encode(password);
        userDto.setPassword(bcryptPasword);

        LOGGER.info("user has received :"+userDto +"bb  "+bcryptPasword);

        User user = modelMapper.map(userDto, User.class);

            userRepository.save(user);
        }

}
