package com.kubudirira.jdbcTemplateOneToOne.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String first_name;
    private  String last_name;
    private  String email;
    private  Passport passport;

}
