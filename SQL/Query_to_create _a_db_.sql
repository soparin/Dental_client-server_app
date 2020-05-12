
CREATE TABLE Patient
(
	Patient_id SERIAL PRIMARY KEY,
	First_name CHARACTER VARYING(20) NOT NULL,
	Last_name CHARACTER VARYING(20) NOT NULL,
	Birthday DATE NOT NULL,
	Medical_policy CHARACTER VARYING(20) NOT NULL UNIQUE,
	SNILS CHARACTER VARYING(20) NOT NULL UNIQUE,
	Last_recept DATE,
	Phone CHARACTER VARYING(20) UNIQUE
);

CREATE TABLE Dentist
(
	Dentist_id SERIAL PRIMARY KEY,
	First_name CHARACTER VARYING(20) NOT NULL,
	Last_name CHARACTER VARYING(20) NOT NULL,
	Birthday DATE NOT NULL,
	Specialization CHARACTER VARYING(30) NOT NULL,
	Carier_start_date DATE NOT NULL,
	Work_phone CHARACTER VARYING(12) UNIQUE
);

CREATE TABLE Reception
(
	Reception_count SERIAL PRIMARY KEY,
	Patient_id INTEGER NULL NULL,
	Dentist_id INTEGER NOT NULL,
	Reception_date DATE NOT NULL,
	Reception_time TIME,
	Office_address CHARACTER VARYING(100) NOT NULL,

	FOREIGN KEY (Patient_id) REFERENCES Patient(Patient_id)
);

CREATE TABLE Work_schedule
(
	Schedule_num SERIAL PRIMARY KEY,
	Dentist_id INTEGER NOT NULL,
	Tickets_by_date DATE NOT NULL,
	Cabinet INTEGER NOT NULL,
	Week_day INTEGER,

	FOREIGN KEY(Dentist_id) REFERENCES Dentist(Dentist_id)
);

CREATE TABLE Tickets_by_date
(
	Schedule_num INTEGER NOT NULL,
	Start_time TIME PRIMARY KEY,
	Finish_time TIME NOT NULL,
	Engaged BOOLEAN,

	FOREIGN KEY (Schedule_num) REFERENCES Work_schedule(Schedule_num)
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
(1, 1, 1, '2018-01-15', '14:00:00', 'Nizhniy Novgorod, Malisa street, 25'),
(2, 2, 1, '2019-04-12', '09:00:00', 'Nizhniy Novgorod, Malisa street, 25'),
(3, 1, 2, '2019-09-11', '12:30:00', 'Nizhniy Novgorod, Harkovskaya street, 4'),
(4, 3, 3, '2018-08-18', '13:30:00', 'Nizhniy Novgorod, Malisa street, 25');
SELECT * FROM Reception;

INSERT INTO work_schedule(Schedule_num, dentist_id, Tickets_by_date, Cabinet, Week_day)
VALUES
(1, 1, '2020-03-12', 5, 4),
(2, 2, '2020-03-12', 6, 4),
(3, 3, '2020-03-12', 5, 4),
(4, 1, '2020-03-13', 10, 5),
(5, 2, '2020-03-13', 10, 5),
(6, 3, '2020-03-13', 11, 5),
(7, 1, '2020-03-16', 5, 5),
(8, 2, '2020-03-16', 6, 5),
(9, 3, '2020-03-16', 5, 5);
SELECT * FROM work_schedule;

INSERT INTO Tickets_by_date(Schedule_num, start_time, finish_time, engaged)
VALUES
(1, '09:00:00', '09:25:00', false),
(1, '09:30:00', '09:55:00', false),
(1, '10:00:00', '10:25:00', true),
(1, '10:30:00', '10:55:00', true),
(1, '11:00:00', '11:25:00', true),
(1, '11:30:00', '11:55:00', true),
(1, '12:00:00', '12:25:00', false),
(1, '12:30:00', '12:55:00', false),
(2, '14:00:00', '04:25:00', false),
(2, '14:30:00', '04:55:00', true),
(2, '15:00:00', '15:25:00', true),
(2, '15:30:00', '15:55:00', false),
(2, '16:00:00', '16:25:00', false),
(2, '16:30:00', '16:55:00', false),
(2, '17:00:00', '17:25:00', true),
(2, '17:30:00', '17:55:00', true),
(2, '18:00:00', '18:25:00', true),
(2, '18:30:00', '18:55:00', false);
SELECT * FROM Tickets_by_date;
