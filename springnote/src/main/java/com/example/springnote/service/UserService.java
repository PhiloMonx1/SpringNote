package com.example.springnote.service;

import com.example.springnote.dto.SignupRequestDto;
import com.example.springnote.model.Users;
import com.example.springnote.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private  final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users registerUser(SignupRequestDto signupRequestDto) {
        Users users = new Users(signupRequestDto);
        usersRepository.save(users);
        return users;
    }

    public Optional<Users> readUsers(String usersname) {
        return usersRepository.findById(usersname);

    }
}
