package com.anup.j6restapi.service;

import com.anup.j6restapi.model.User;
import com.anup.j6restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
       return this.userRepository.findAll();
    }

    public Optional<User> findById(Long id){
       return userRepository.findById(id);

    }


    public void deleteById(Long id){
      userRepository.deleteById(id);

    }



    public void save(User user){
        userRepository.save(user);
    }
    public void update(User user,Long id){
        userRepository.save(user);
    }




}
