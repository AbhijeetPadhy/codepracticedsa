package com.abhijeet.codepracticedsa.data.repository;

import com.abhijeet.codepracticedsa.data.entity.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);
}
