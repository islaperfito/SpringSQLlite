package com.example.springsqllite.controller;

import com.example.springsqllite.user.User;
import com.example.springsqllite.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> readAllUsers()
    {
        List<User> userList=userRepository.findAll();
        return userList;
    }

    public String deleteAllUsers()
    {
       userRepository.deleteAll();
        return "Deleted all user successfully";
    }


    public String createUser(User user){
        try {
            userRepository.save(user);
            return "User Created Successfully!";
        }catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }


    public String deleteUser(Integer id)
    {
        userRepository.deleteById(id);
        return "Deleted all user successfully";
    }

    public String updateUser(User user){
        try {
            userRepository.save(user);
            return "User Updated Successfully";
        }catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }




}
