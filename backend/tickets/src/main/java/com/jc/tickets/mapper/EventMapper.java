package com.jc.tickets.mapper;

import java.util.ArrayList;
import java.util.List;

import com.jc.tickets.dto.EventDto;
import com.jc.tickets.entity.Event;

public class EventMapper {
    public static EventDto mapToDto(Event event, EventDto eventDto) {
        eventDto.setEveUuid(event.getEveUuid());
        eventDto.setTitle(event.getTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setVenue(event.getVenue());
        return eventDto;
    }

    public static Event mapToEntity(EventDto eventDto, Event event) {
        event.setEveUuid(eventDto.getEveUuid());
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setVenue(eventDto.getVenue());
        return event;
    }

    public static EventDto convertToDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setEveUuid(event.getEveUuid());
        eventDto.setTitle(event.getTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setVenue(event.getVenue());
        return eventDto;
    }

    public static Event convertToEntity(EventDto eventDto) {
        Event event = new Event();
        event.setEveUuid(eventDto.getEveUuid());
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setVenue(eventDto.getVenue());
        return event;
    }

    public static List<EventDto> convertToEventDtoList(List<Event> eventList) {
        List<EventDto> eventDtoList = new ArrayList<>();
        for (Event event : eventList) {
            EventDto eventDto = new EventDto();
            eventDto.setTitle(event.getTitle());
            eventDto.setDescription(event.getDescription());
            eventDto.setVenue(event.getVenue());
            eventDtoList.add(eventDto);
        }
        return eventDtoList;
    }
}
