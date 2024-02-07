use test;

CREATE TABLE phonebook (
  id int NOT NULL AUTO_INCREMENT,
  lastname varchar(25),
  phone int,
  PRIMARY KEY (id)
) ;

alter table phonebook modify column lastname varchar(25) 
character set utf8mb4 collate utf8mb4_general_ci not null;

INSERT INTO phonebook (lastname, phone)
VALUES
	('Скорняков', 6555329),
	('Toleyko', 7281391);
