package com.tatianaborda.linkedInproject.tasks;

import com.tatianaborda.linkedInproject.services.MeetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ScheduleRunner implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduleRunner.class);

    @Autowired
    private MeetingService meetingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Schedule of Meetings: ");
        meetingService.getAllMeetings().forEach(meeting -> {
            LOG.info(meeting.toString());
        });
            LOG.info("END OF LOG");
    }
}
