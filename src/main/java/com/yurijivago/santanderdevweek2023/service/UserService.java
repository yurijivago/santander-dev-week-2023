package com.yurijivago.santanderdevweek2023.service;

import com.yurijivago.santanderdevweek2023.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findById(Long id);
    User create(User user);
    List<User> fildAll();

    void delete(Long id);

    User update(Long id, User user);
}
