
CREATE TABLE Patient
(
	Patient_id SERIAL PRIMARY KEY,
	First_name CHARACTER VARYING(20) NOT NULL,
	Last_name CHARACTER VARYING(20) NOT NULL,
	Birthday CHARACTER VARYING(20) NOT NULL,
	Medical_policy CHARACTER VARYING(20) NOT NULL UNIQUE,
	SNILS CHARACTER VARYING(20) NOT NULL UNIQUE,
	Last_recept CHARACTER VARYING(20),
	Phone CHARACTER VARYING(20) UNIQUE
);

CREATE TABLE Dentist
(
	Dentist_id SERIAL PRIMARY KEY,
	First_name CHARACTER VARYING(20) NOT NULL,
	Last_name CHARACTER VARYING(20) NOT NULL,
	Birthday CHARACTER VARYING(20) NOT NULL,
	Specialization CHARACTER VARYING(30) NOT NULL,
	Carier_start_date CHARACTER VARYING(20) NOT NULL,
	Work_phone CHARACTER VARYING(12) UNIQUE
);

CREATE TABLE Reception
(
	Reception_count SERIAL PRIMARY KEY,
	Patient_id INTEGER NULL NULL,
	Dentist_id INTEGER NOT NULL,
	Reception_date CHARACTER VARYING(20) NOT NULL,
	Reception_time CHARACTER VARYING(5),
	Office_address CHARACTER VARYING(100) NOT NULL,

	FOREIGN KEY (Patient_id) REFERENCES Patient(Patient_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Work_schedule
(
	Schedule_num SERIAL PRIMARY KEY,
	Dentist_id INTEGER NOT NULL,
	Tickets_by_date CHARACTER VARYING(20) NOT NULL,
	Cabinet INTEGER NOT NULL,
	Week_day INTEGER,

	FOREIGN KEY(Dentist_id) REFERENCES Dentist(Dentist_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Tickets_by_date
(
	Ticket_id SERIAL PRIMARY KEY ,
	Schedule_num INTEGER NOT NULL,
	Start_time CHARACTER VARYING(5) NOT NULL,
	Finish_time CHARACTER VARYING(5) NOT NULL,
	Engaged BOOLEAN,

	FOREIGN KEY (Schedule_num) REFERENCES Work_schedule(Schedule_num) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Patient(patient_id, first_name, last_name, birthday, mediccal_policy, snils, last_recept, phone)
VALUES
(1, 'Andreeva', 'Elena', '1989-02-01', '7896-868-872-234', '435-5345-43-23', ' 2019-09-11', '89057749834'),
(2, 'Svetin', 'Mikhail', '1978-05-11', '7566-434-871-879', '435-6785-23-33', '2019-04-12', '89876557545'),
(3, 'Mikheev', 'Alexandr', '1996-07-03', '7858-569-378-964', '432-5682-57-11', '2018-08-18', '89061256890');
SELECT * FROM Patient;

INSERT INTO Dentist(dentist_id, first_name, last_name, birthday, specialization, carier_start_date, work_phone)
VALUES
(1, 'Sinicin', 'Alexey', '1973-06-13', 'therapy', '2008-06-14', '89058302834'),
(2, 'Sharidze', 'Marat', '1980-01-02', 'surgeon', '2007-12-20', '89876555678'),
(3, 'Suslikova', 'Alexandra', '1968-02-27', 'therapy', '2012-09-02', '89911285690');
SELECT * FROM Dentist;

INSERT INTO Reception(reception_count, patient_id, dentist_id, reception_date, reception_time, office_address)
VALUES
(1, 1, 1, '2018-01-15', '14:00', 'Nizhniy Novgorod, Malisa street, 25'),
(2, 2, 1, '2019-04-12', '09:00', 'Nizhniy Novgorod, Malisa street, 25'),
(3, 1, 2, '2019-09-11', '12:30', 'Nizhniy Novgorod, Harkovskaya street, 4'),
(4, 3, 3, '2018-08-18', '13:30', 'Nizhniy Novgorod, Malisa street, 25');
SELECT * FROM Reception;

INSERT INTO work_schedule(Schedule_num, dentist_id, Tickets_by_date, Cabinet)
VALUES
(1, 3, '2020-03-12', 5),
(2, 1, '2020-03-12', 6),
(3, 2, '2020-03-12', 5),
SELECT * FROM work_schedule;

INSERT INTO Tickets_by_date(Schedule_num, start_time, finish_time, engaged)
VALUES
(1, '09:00', '09:18', false),
(1, '09:20', '09:38', false),
(1, '09:40', '09:58', true),
(1, '10:00', '10:18', true),
(1, '10:20', '10:38', true),
(1, '10:40', '10:00', true),
(1, '11:00', '11:00', true),
(1, '11:20', '11:00', true),
(1, '11:40', '10:00', true),
(1, '12:00', '12:00', false),
(1, '12:20', '12:38', false),
(1, '12:40', '10:58', true),
(2, '13:00', '13:18', false),
(2, '13:20', '13:38', true),
(2, '13:40', '13:58', true),
(2, '14:30', '14:18', false),
(2, '14:20', '14:38', false),
(2, '14:40', '14:58', false),
(2, '15:00', '15:18', true),
(2, '15:20', '15:38', true),
(2, '15:40', '15:58', true),
(2, '16:00', '16:18', false),
(2, '16:20', '16:38', true),
(2, '16:40', '16:58', true),
(3, '17:00', '17:18', false),
(3, '17:20', '17:38', false),
(3, '17:40', '17:58', true),
(3, '18:00', '18:18', true),
(3, '18:20', '18:38', true),
(3, '18:40', '18:58', true),
(3, '19:00', '19:18', false),
(3, '19:30', '19:38', false),
(3, '19:00', '19:58', true),
(3, '20:30', '20:18', true),
(3, '20:00', '20:38', true),
(3, '20:30', '20:58', false);
SELECT * FROM Tickets_by_date;
