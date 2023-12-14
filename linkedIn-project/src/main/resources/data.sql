INSERT INTO meeting (id, subject, date) VALUES(1, 'personal progress', '2023-12-21');
INSERT INTO meeting (id, subject, date) VALUES(2, 'general', '2023-12-20');
INSERT INTO meeting (id, subject, date) VALUES(3, 'team formation', '2023-12-23');

INSERT INTO person (id, name, surname) VALUES(1, 'David', 'Bowie');
INSERT INTO person (id, name, surname) VALUES(2, 'Jack', 'Killa');
INSERT INTO person (id, name, surname) VALUES(3, 'Lars', 'Von Trier');
INSERT INTO person (id, name, surname) VALUES(4, 'Uma', 'Thurman');
INSERT INTO person (id, name, surname) VALUES(5, 'Virgilio', 'Inferno');

INSERT INTO attendee (meeting_id, person_id) VALUES(1, 1);
INSERT INTO attendee (meeting_id, person_id) VALUES(1, 2);
INSERT INTO attendee (meeting_id, person_id) VALUES(2, 1);
INSERT INTO attendee (meeting_id, person_id) VALUES(2, 3);
INSERT INTO attendee (meeting_id, person_id) VALUES(2, 4);
INSERT INTO attendee (meeting_id, person_id) VALUES(3, 1);
INSERT INTO attendee (meeting_id, person_id) VALUES(3, 2);
INSERT INTO attendee (meeting_id, person_id) VALUES(3, 3);
INSERT INTO attendee (meeting_id, person_id) VALUES(3, 4);