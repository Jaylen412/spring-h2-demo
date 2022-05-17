package com.jayscode.springh2demo.repo;

import com.jayscode.springh2demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
