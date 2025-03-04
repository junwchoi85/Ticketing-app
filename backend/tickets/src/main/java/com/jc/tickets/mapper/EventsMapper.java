package com.jc.tickets.mapper;

import java.util.ArrayList;
import java.util.List;

import com.jc.tickets.dto.EventsDto;
import com.jc.tickets.entity.Events;

public class EventsMapper {
    public static EventsDto mapToDto(Events events, EventsDto eventsDto) {
        eventsDto.setEveUuid(events.getEveUuid());
        eventsDto.setTitle(events.getTitle());
        eventsDto.setDescription(events.getDescription());
        eventsDto.setVenue(events.getVenue());
        return eventsDto;
    }

    public static Events mapToEntity(EventsDto eventsDto, Events events) {
        events.setEveUuid(eventsDto.getEveUuid());
        events.setTitle(eventsDto.getTitle());
        events.setDescription(eventsDto.getDescription());
        events.setVenue(eventsDto.getVenue());
        return events;
    }

    public static EventsDto convertToDto(Events events) {
        EventsDto eventsDto = new EventsDto();
        eventsDto.setEveUuid(events.getEveUuid());
        eventsDto.setTitle(events.getTitle());
        eventsDto.setDescription(events.getDescription());
        eventsDto.setVenue(events.getVenue());
        return eventsDto;
    }

    public static Events convertToEntity(EventsDto eventsDto) {
        Events events = new Events();
        events.setEveUuid(eventsDto.getEveUuid());
        events.setTitle(eventsDto.getTitle());
        events.setDescription(eventsDto.getDescription());
        events.setVenue(eventsDto.getVenue());
        return events;
    }

    public static List<EventsDto> convertToEventsDtoList(List<Events> events) {
        List<EventsDto> eventsDtoList = new ArrayList<>();
        for (Events event : events) {
            EventsDto eventsDto = new EventsDto();
            eventsDto.setTitle(event.getTitle());
            eventsDto.setDescription(event.getDescription());
            eventsDto.setVenue(event.getVenue());
            eventsDtoList.add(eventsDto);
        }
        return eventsDtoList;
    }
}
