package com.tatianaborda.linkedInproject.data;

import com.tatianaborda.linkedInproject.models.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "meetings")
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
