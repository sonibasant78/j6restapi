package com.anup.j6restapi.controller;

import com.anup.j6restapi.model.User;
import com.anup.j6restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class HomeController {

    @Autowired
    UserService userService;


    @GetMapping({"/","/home"})
    public String home() {
        return "<h1>welcome to restpur</h1>";


    } @GetMapping("/user/all")
        public List<User> getAllUsers() {
            return userService.findAll();


        } @GetMapping("/user/{id}")
            public ResponseEntity<User> getUser(@PathVariable Long id){
                if(userService.findById(id).isPresent()){
                    return new ResponseEntity<>(userService.findById(id).get(), HttpStatus.OK);
                }
                return  ResponseEntity.notFound().header("Message","Not Found").build() ;
    }


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }
      @PostMapping("/user/register")
    public void registerUser(@RequestBody  User user){
        userService.save(user);
      }
      @PutMapping("/user/update/{id}")
    public void updateUser(@RequestBody User user,@PathVariable Long id){
        userService.update(user,id);
      }
}
