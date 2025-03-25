package com.edwin.nexus_api.repository;

import com.edwin.nexus_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
