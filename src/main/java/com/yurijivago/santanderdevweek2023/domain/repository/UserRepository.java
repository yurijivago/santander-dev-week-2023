package com.yurijivago.santanderdevweek2023.domain.repository;

import com.yurijivago.santanderdevweek2023.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existisByAccountNumber(String accountNumber);
}
