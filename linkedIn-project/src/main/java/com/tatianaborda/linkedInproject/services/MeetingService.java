package com.tatianaborda.linkedInproject.services;

import com.tatianaborda.linkedInproject.data.MeetingRepository;
import com.tatianaborda.linkedInproject.models.Meeting;
import com.tatianaborda.linkedInproject.models.Person;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public List<Meeting> getAllMeetings(){
        return meetingRepository.findAll();
    }

    public Optional<Meeting> getById(long id){
        return meetingRepository.findById(id);
    }
}
