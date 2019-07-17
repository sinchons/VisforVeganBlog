package com.sda.finalproject.plantwatering.blog.repositories;

import com.sda.finalproject.plantwatering.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
