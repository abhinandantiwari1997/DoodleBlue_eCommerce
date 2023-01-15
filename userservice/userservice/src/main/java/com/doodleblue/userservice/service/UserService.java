package com.doodleblue.userservice.service;

import java.util.Optional;

import com.doodleblue.userservice.entity.User;
import com.doodleblue.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceI {

    @Autowired
    UserRepository userRepository;

    @Override
    public String login(String email, String password) {

        long id = userRepository.getIdByEmail(email);
        Optional<User> findById = userRepository.findById(id);
        if (findById.isPresent()) {
            User user = findById.get();
            if (user.getUserPassword().equals(password)) {
                return  "User";
            }
            return "Incorrect Password";
        }
        return "The User is Not Present";
    }

    public String registerUser(User user) {
        user.setUserPassword(encryptPassword(user.getUserPassword()));
        userRepository.save(user);
        return "User Successfully Registered";
    }
    private String encryptPassword(String password) {
        // Use a strong encryption algorithm, such as bcrypt
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
