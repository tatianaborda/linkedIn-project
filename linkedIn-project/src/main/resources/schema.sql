CREATE TABLE meeting (
    id BIGSERIAL PRIMARY KEY,
    subject VARCHAR(128) NOT NULL,
    date DATETIME NOT NULL
);

CREATE TABLE person (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL
);

CREATE TABLE attendee (
    meeting_id BIGSERIAL,
    person_id BIGSERIAL,
    PRIMARY KEY(meeting_id, person_id),
    FOREIGN KEY(meeting_id) REFERENCES meeting(id),
    FOREIGN KEY(person_id) REFERENCES person(id)
);