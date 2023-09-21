package com.yurijivago.santanderdevweek2023.service.impl;

import com.yurijivago.santanderdevweek2023.domain.model.User;
import com.yurijivago.santanderdevweek2023.domain.repository.UserRepository;
import com.yurijivago.santanderdevweek2023.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public List<User> fildAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsByAccountNumber(findById(id).getAccount().getNumber())) {
            throw new IllegalArgumentException("User Not found for this ID (" + id + ")");
        }
        userRepository.deleteById(id);
    }

    @Override
    public User update(Long id, User user) {
        User userToUptade = findById(id);

        userToUptade.setAccount(user.getAccount());
        userToUptade.setCard(user.getCard());
        userToUptade.setFeatures(user.getFeatures());
        userToUptade.setNews(user.getNews());
        userToUptade.setName(user.getName());

        return userRepository.save(userToUptade);
    }
}