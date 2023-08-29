package com.boardtest.demo.applications;

import com.boardtest.demo.exceptions.NameNotExist;
import com.boardtest.demo.models.User;
import com.boardtest.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(String name, String password){
        if(!userRepository.existsByName(name)) {
            throw new NameNotExist();
        }

        User user = userRepository.findByName(name);

        System.out.println(user.name());

        boolean isPassMatch = passwordEncoder.matches(password, user.password());


        return isPassMatch;
    }
}
