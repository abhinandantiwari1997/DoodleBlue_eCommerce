package com.doodleblue.userservice.config;

import com.doodleblue.userservice.entity.User;
import com.doodleblue.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.getUserByEmail(username);
        if(user==null)
        {
            throw new RuntimeException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
