package miu.edu.Authservice.security;

import lombok.Data;
import miu.edu.UserService.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Data
public class CustomUserDetails implements UserDetails {
    private String username;
    private String password;
    //private  String role;

    private List<SimpleGrantedAuthority> authorities;

    public CustomUserDetails(User user) {
        this.username =user.getUsername();
        this.password =user.getPassword();
       // this.authorities = (user.getRole()).
       // this.authorities.add(user.getRole());
//        this.authorities = (user.getRole()).stream().map(role -> role.getRole()).
//                map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        this.authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
