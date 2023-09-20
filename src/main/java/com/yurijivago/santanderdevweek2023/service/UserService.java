package com.yurijivago.santanderdevweek2023.service;

import com.yurijivago.santanderdevweek2023.domain.model.User;

public interface UserService {
    User findById(Long id);
    User creat(User user);
}
