package com.tatianaborda.linkedInproject.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tatianaborda.linkedInproject.models.Meeting;
import com.tatianaborda.linkedInproject.models.Person;
import com.tatianaborda.linkedInproject.services.MeetingService;
import com.tatianaborda.linkedInproject.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageListener {

    private static final Logger LOG = LoggerFactory.getLogger(MessageListener.class);

    private final ObjectMapper mapper;
    private final PersonService personService;
    private final MeetingService meetingService;

    public MessageListener(ObjectMapper mapper, PersonService personService, MeetingService meetingService) {
        this.mapper = mapper;
        this.personService = personService;
        this.meetingService = meetingService;
    }

    public void receiveMessage(String message){
        try {
            MessageData data = mapper.readValue(message, MessageData.class);
            Optional<Person> person = personService.getById(data.getIdAttendee());
            if(person.isEmpty()){
                LOG.warn("The message was received but the person {} doesn't exist",
                        data.getIdAttendee());
            }
            Optional <Meeting> meeting = meetingService.getById(data.getIdMeeting());
            if(meeting.isEmpty()){
                LOG.warn("The message was received but the meeting {} doesn't exist",
                        data.getIdMeeting());
            }
            if(person.isPresent() && meeting.isPresent()){
                LOG.info("{} {} has a meeting at {}",
                        person.get().getName(),
                        person.get().getSurname(),
                        meeting.get().getDate());
            }
        } catch (JsonProcessingException e) {
            LOG.warn("The message is incorrect", e);
        }
    }
}
