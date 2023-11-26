package com.example.socialratingapi.data.repository;

import com.example.socialratingapi.data.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByRole(Users.Role role);
    Users findByMail(String mail);
}
