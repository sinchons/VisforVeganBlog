package com.sda.finalproject.plantwatering.blog.services;

import com.sda.finalproject.plantwatering.blog.models.User;
import com.sda.finalproject.plantwatering.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User username = userRepository.findByUsername(s);
        if (username == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "USER";
            }
        });

        return new org.springframework.security.core.userdetails.User(
                username.getUsername(),
                username.getPassword(),
                grantedAuthorities);
    }

    public void setTodoUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
