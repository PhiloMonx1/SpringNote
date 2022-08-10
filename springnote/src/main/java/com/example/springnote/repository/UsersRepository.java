package com.example.springnote.repository;

import com.example.springnote.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,String> {
}
