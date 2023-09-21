package com.yurijivago.santanderdevweek2023.service;

import com.yurijivago.santanderdevweek2023.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById(Long id);
    User create(User user);
}
