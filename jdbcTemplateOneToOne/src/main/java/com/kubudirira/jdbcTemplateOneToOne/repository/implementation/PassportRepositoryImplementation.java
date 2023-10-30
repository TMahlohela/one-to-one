package com.kubudirira.jdbcTemplateOneToOne.repository.implementation;

import com.kubudirira.jdbcTemplateOneToOne.model.Passport;
import com.kubudirira.jdbcTemplateOneToOne.model.rowmapper.PassportRowMapper;
import com.kubudirira.jdbcTemplateOneToOne.repository.PassportRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
@Slf4j
public class PassportRepositoryImplementation implements PassportRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Passport> findAll() {
        String sql = """
                SELECT id , expiry_date
                FROM passports
                LIMIT 100;
                """;


        return jdbcTemplate.query(sql,new PassportRowMapper());
    }

    @Override
    public Optional<Passport> findById(int id) {
        String sql = """
           SELECT id , expiry_date
           FROM passports
           WHERE id = ?;
          """;
        return jdbcTemplate.query(sql,new PassportRowMapper(),id)
                .stream()
                .findFirst();
    }

    @Override
    public int deletePassport(int id) {
        String sql = """
           DELETE FROM passports
           WHERE id = ?;
           """;
        return jdbcTemplate.update(sql,id);
    }
}
