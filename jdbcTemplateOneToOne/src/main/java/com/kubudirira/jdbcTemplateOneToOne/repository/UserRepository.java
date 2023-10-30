package com.kubudirira.jdbcTemplateOneToOne.repository;


import com.kubudirira.jdbcTemplateOneToOne.model.Passport;
import com.kubudirira.jdbcTemplateOneToOne.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();
    int addUser(User user);

    Optional<User> findById(int id);
    int deleteUser(int id);
    int updateUser(int id, User user);

    public int addPassportToUser(int user_id, Passport passport);

}


