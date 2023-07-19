package miu.edu.Authservice.security;

import miu.edu.Authservice.repository.AuthRepository;
import miu.edu.Authservice.service.AuthService;
import miu.edu.UserService.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authRepository.findByUsername(username);
        UserDetails userDetails = new CustomUserDetails(user);
        return userDetails;
    }
}
