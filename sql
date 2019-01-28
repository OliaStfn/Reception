CREATE database reception;
USE reception;


CREATE TABLE person(
id INT(11) primary key auto_increment,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
date_of_birth date NOT NULL
)Engine=InnoDB;

CREATE TABLE doctor(
id INT(11) primary key auto_increment,
specialization VARCHAR(50),
person_id INT(11) NOT NULL,
FOREIGN KEY (person_id) REFERENCES person (id)
)Engine=InnoDB;

CREATE TABLE personal_file(
id INT(11) primary key auto_increment,
phone_number VARCHAR(20) NOT NULL,
registration_date timestamp default now(),
person_id INT(11) not null,
FOREIGN KEY (person_id) REFERENCES person (id)
)Engine=InnoDB;

CREATE TABLE appointment(
id INT(11) primary key auto_increment,
cab_number VARCHAR(6) NOT NULL,
date_of_visit timestamp NOT NULL,
doctor_id INT(11) NOT NULL,
personal_file_id INT(11) NOT NULL,
FOREIGN KEY (personal_file_id) REFERENCES personal_file (id),
FOREIGN KEY (doctor_id) REFERENCES doctor (id)
)Engine=InnoDB;

CREATE TABLE doctor_schedule(
id INT(11) primary key auto_increment,
doctor_id INT(11) NOT NULL,
FOREIGN KEY (doctor_id) REFERENCES doctor (id)
)Engine=InnoDB;

CREATE TABLE timetable(
id INT(11) primary key auto_increment,
day_of_week varchar(20) not null,
time_start time NOT NULL,
time_end time NOT NULL,
schedule_id INT(11) NOT NULL,
FOREIGN KEY (schedule_id) REFERENCES doctor_schedule (id)
)Engine=InnoDB;
