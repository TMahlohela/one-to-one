package com.kubudirira.jdbcTemplateOneToOne.repository.implementation;

import com.kubudirira.jdbcTemplateOneToOne.model.Passport;
import com.kubudirira.jdbcTemplateOneToOne.model.User;
import com.kubudirira.jdbcTemplateOneToOne.model.rowmapper.UserRowMapper;
import com.kubudirira.jdbcTemplateOneToOne.repository.PassportRepository;
import com.kubudirira.jdbcTemplateOneToOne.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.kubudirira.jdbcTemplateOneToOne.query.PassportQuery.*;
import static com.kubudirira.jdbcTemplateOneToOne.query.UserQuery.*;


@Repository
@AllArgsConstructor
@Slf4j
public class UserRepositoryImplementation  implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final PassportRepository passportRepository;


    @Override
    public List<User> findAll() {


        List<User> users =  jdbcTemplate.query(SELECT_USER_QUERY,new UserRowMapper());

        //presentation assignment. Each user get their Ids.
        for(User user : users ){
                //add their passport for presentation
            if(passportRepository.findById(user.getId()).isPresent()){
                user.setPassport( passportRepository.findById(user.getId()).get());
            }else{
                user.setPassport(null);
            }
        }
        return users;
    }

    @Override
    public int addUser(User user) {

        return  jdbcTemplate.update(INSERT_USER_QUERY, user.getFirst_name(), user.getLast_name(), user.getEmail());

    }

    @Override
    public int addPassportToUser(int user_id, Passport passport) {

        //You have to validate here
        User user = findById(user_id).get();
        user.setPassport(passport);

        return  jdbcTemplate.update(INSERT_PASSPORT_QUERY, user_id,passport.getExpiry_date());

    }

    @Override
    public Optional<User> findById(int id) {

        return jdbcTemplate.query(SELECT_USER_BY_ID_QUERY,new UserRowMapper(),id)
                .stream()
                .findFirst();
    }

    @Override
    public int deleteUser(int id) {
        return jdbcTemplate.update(DELETE_USER_QUERY,id);
    }

    @Override
    public int updateUser(int id, User user) {

        return jdbcTemplate.update(UPDATE_USER_QUERY,
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),id);
    }

}
