package com.tatianaborda.linkedInproject.controllers;

import com.tatianaborda.linkedInproject.models.Meeting;
import com.tatianaborda.linkedInproject.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/meetings")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @GetMapping
    public String getAllMeetings(Model model){
        model.addAttribute("meetings", meetingService.getAllMeetings());
        return "meetings";
    }
}
