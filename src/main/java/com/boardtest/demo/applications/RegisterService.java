package com.boardtest.demo.applications;

import com.boardtest.demo.exceptions.NameAlreadyTaken;
import com.boardtest.demo.models.User;
import com.boardtest.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public String register(String name, String password){
        if(userRepository.existsByName(name)) {
            throw new NameAlreadyTaken(name);
        }

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(name, encodedPassword);
        userRepository.save(user);
        return "created";
    }

}
