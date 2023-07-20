package miu.edu.Authservice.service;

import miu.edu.Authservice.domain.LoginRequest;
import miu.edu.Authservice.domain.LoginResponse;
import miu.edu.Authservice.repository.AuthRepository;
import miu.edu.Authservice.security.JwtUtil;
import miu.edu.Authservice.security.MyUserDetails;
import miu.edu.UserService.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    MyUserDetails myUserDetails;
    @Autowired
    AuthRepository authRepository;
    @Autowired
    ModelMapper mapper;

//    @Autowired
//    BCryptPasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request){
        //System.out.println(request.getPassword());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetail =  myUserDetails.loadUserByUsername(request.getUsername());
        String jwtToken = jwtUtil.generateToken(userDetail);
        String refereshToken = jwtUtil.generateRefereshToken(request.getUsername());
        return new LoginResponse(jwtToken,refereshToken);
    }
}
