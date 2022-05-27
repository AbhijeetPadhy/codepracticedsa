package com.abhijeet.codepracticedsa.data.repository;

import com.abhijeet.codepracticedsa.data.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
}
