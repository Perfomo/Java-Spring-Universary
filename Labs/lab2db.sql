CREATE TABLE my_lab_db.lessons (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(15),
  day_of_week varchar(15),
  classroom_num int,
  PRIMARY KEY (id)
);

CREATE TABLE my_lab_db.teachers (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(30),
  lesson varchar(15),
  lessons_amount int,
  student_amount int,
  lesson_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (lesson_id) REFERENCES my_lab_db.lessons(id));