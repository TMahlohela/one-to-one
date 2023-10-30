package com.kubudirira.jdbcTemplateOneToOne.model.rowmapper;

import com.kubudirira.jdbcTemplateOneToOne.model.Passport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PassportRowMapper implements RowMapper<Passport> {
    @Override
    public Passport mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Passport(rs.getInt("id"),
                rs.getString("expiry_date"));
    }
}
