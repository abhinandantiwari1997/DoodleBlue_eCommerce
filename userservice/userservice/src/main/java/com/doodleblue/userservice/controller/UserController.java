package com.doodleblue.userservice.controller;
import com.doodleblue.userservice.entity.User;
import com.doodleblue.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email,@RequestParam String password) {
        String s = userService.login(email, password);
        return new ResponseEntity<String>(s, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        String message = userService.registerUser(user);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
