package com.shoptemplate.repositories;

import com.shoptemplate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}