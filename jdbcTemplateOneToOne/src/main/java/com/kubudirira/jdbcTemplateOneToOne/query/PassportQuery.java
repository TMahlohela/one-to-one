package com.kubudirira.jdbcTemplateOneToOne.query;

public class PassportQuery {

    public static final String INSERT_PASSPORT_QUERY = """
                                                        INSERT INTO Passports(id,expiry_date)
                                                        VALUES (?,?);
                                                        """;
}
