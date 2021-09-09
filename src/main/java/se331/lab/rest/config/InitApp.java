package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    OrganizerRepository organizerRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("Chiang Mai").build());

        Participant a, b, c, d, e;
        a = participantRepository.save(Participant.builder().name("a").telNo("1234567890").build());
        b = participantRepository.save(Participant.builder().name("b").telNo("1234567891").build());
        c = participantRepository.save(Participant.builder().name("c").telNo("1234567892").build());
        d = participantRepository.save(Participant.builder().name("d").telNo("1234567893").build());
        e = participantRepository.save(Participant.builder().name("e").telNo("1234567894").build());

        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false).build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent.getParticipants().add(a);
        tempEvent.getParticipants().add(b);
        tempEvent.getParticipants().add(c);
        a.getEventHistory().add(tempEvent);
        b.getEventHistory().add(tempEvent);
        c.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false).build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent.getParticipants().add(b);
        tempEvent.getParticipants().add(c);
        tempEvent.getParticipants().add(d);
        b.getEventHistory().add(tempEvent);
        c.getEventHistory().add(tempEvent);
        d.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false).build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        tempEvent.getParticipants().add(c);
        tempEvent.getParticipants().add(d);
        tempEvent.getParticipants().add(e);
        c.getEventHistory().add(tempEvent);
        d.getEventHistory().add(tempEvent);
        e.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true).build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        tempEvent.getParticipants().add(e);
        tempEvent.getParticipants().add(a);
        tempEvent.getParticipants().add(b);
        e.getEventHistory().add(tempEvent);
        a.getEventHistory().add(tempEvent);
        b.getEventHistory().add(tempEvent);
    }
}
