package se331.lab.rest.utils;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.rest.dto.EventDTO;
import se331.lab.rest.entity.Event;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDTO getEventDTO(Event event);
    List<EventDTO> getEventDTO(List<Event> events);
}
