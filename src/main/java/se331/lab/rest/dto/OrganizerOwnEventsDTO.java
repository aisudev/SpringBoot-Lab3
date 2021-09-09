package se331.lab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab.rest.entity.Participant;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerOwnEventsDTO {
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    List<Participant> participants;
}
