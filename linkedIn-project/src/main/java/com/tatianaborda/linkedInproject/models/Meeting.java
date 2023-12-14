package com.tatianaborda.linkedInproject.models;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String subject;
    private ZonedDateTime date;

    @ManyToMany
    @JoinTable(name="attendee",
            joinColumns = {@JoinColumn(name="meeting_id")},
            inverseJoinColumns = {@JoinColumn(name="person_id")})
    private List<Person> attendees = new ArrayList<>();

    public Meeting(){

    }

    public Meeting(long id, String subject, ZonedDateTime date){
        this.id = id;
        this.subject = subject;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public List<Person> getAttendees(){
        return attendees;
    }

    public void addAttendee(Person attendee){
        attendees.add(attendee);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", date=" + date +
                '}';
    }
}
