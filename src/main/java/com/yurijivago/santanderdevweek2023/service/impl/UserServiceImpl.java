package com.yurijivago.santanderdevweek2023.service.impl;

import com.yurijivago.santanderdevweek2023.domain.model.User;
import com.yurijivago.santanderdevweek2023.domain.repository.UserRepository;
import com.yurijivago.santanderdevweek2023.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User creat(User userToCreate) {
        if(userRepository.existisByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
