package com.kubudirira.jdbcTemplateOneToOne.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    private Integer id;
    private String expiry_date;
}
