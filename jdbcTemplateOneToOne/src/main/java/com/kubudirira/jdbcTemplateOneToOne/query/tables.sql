USE jdbc1to1;

DROP TABLE IF EXISTS Users;

CREATE TABLE Users(

	id 				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name 		VARCHAR(50) NOT NULL,
    last_name 		VARCHAR(50) NOT NULL,
    email 			VARCHAR(100) NOT NULL,
	CONSTRAINT UQ_Users_Email UNIQUE(email)
);

DROP TABLE IF EXISTS Passports;

CREATE TABLE Passports(

	id 				BIGINT  PRIMARY KEY  REFERENCES Users(id),
    expiry_date 	DATE NOT NULL
);

SELECT * FROM passports;
SELECT * FROM users;

/*******************USER INSERT **********************/

INSERT INTO Users( first_name, last_name, email)
VALUES ("Karabo","Kekana","karabo2@gmail.com");

INSERT INTO Users( first_name, last_name, email)
VALUES ("Joy","Dladla","joy@gmail.com");

INSERT INTO Users( first_name, last_name, email)
VALUES ("Vusi","Nkosi","vusi@gmail.com");

INSERT INTO Users( first_name, last_name, email)
VALUES ("Kevin","LeMark","kevin@gmail.com");


