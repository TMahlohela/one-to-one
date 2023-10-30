package com.kubudirira.jdbcTemplateOneToOne.repository;

import com.kubudirira.jdbcTemplateOneToOne.model.Passport;
import com.kubudirira.jdbcTemplateOneToOne.model.User;

import java.util.List;
import java.util.Optional;

public interface PassportRepository {

    List<Passport> findAll();
    Optional<Passport> findById(int id);
    int deletePassport(int id);


}
