package com.kubudirira.jdbcTemplateOneToOne.controller;

import com.kubudirira.jdbcTemplateOneToOne.model.Passport;
import com.kubudirira.jdbcTemplateOneToOne.model.User;
import com.kubudirira.jdbcTemplateOneToOne.repository.PassportRepository;
import com.kubudirira.jdbcTemplateOneToOne.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserRepository userRepository;
    private final PassportRepository passportRepository;

    @GetMapping("/all")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public void addUser( @RequestBody User user){
        userRepository.addUser(user);
    }

    @PostMapping("/add/{id}")
    public int addPassportToUser( @PathVariable("id") int user_id,@RequestBody Passport passport){
        return userRepository.addPassportToUser(user_id,passport);
    }


    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id){

        passportRepository.deletePassport(id);
        userRepository.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public int updateUser( @RequestBody User user, @PathVariable("id") int id){

        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        
        existingUser.setFirstName(updateUser.getFirstName());
        existingUser.setLastName(updateUser.getLastName());
        existingUser.setEmail(updateUser.getEmail());

        //save
        return userRepository.updateUser(id,user);
    }

    //update
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable  userId, @RequestBody User updateUser) {
        User existingUser = userService.getUserById(userId);

        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        
        existingUser.setFirstName(updateUser.getFirstName());
        existingUser.setLastName(updateUser.getLastName());
        existingUser.setEmail(updateUser.getEmail());

        //save
        userService.saveUser(existingUser);

        return ResponseEntity.ok(existingUser);
    }
}
