package com.tatianaborda.linkedInproject.controllers;

import com.tatianaborda.linkedInproject.models.Meeting;
import com.tatianaborda.linkedInproject.services.MeetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
public class MeetingRestController {

    private MeetingService meetingService;

    public MeetingRestController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    public List<Meeting> getAllMeetings(){
        return meetingService.getAllMeetings();
    }
}
