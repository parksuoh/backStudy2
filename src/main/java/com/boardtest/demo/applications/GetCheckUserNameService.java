package com.boardtest.demo.applications;

import com.boardtest.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetCheckUserNameService {
    private final UserRepository userRepository;

    public GetCheckUserNameService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean checkUserName(String name) {
        return userRepository.existsByName(name);
    }

}
