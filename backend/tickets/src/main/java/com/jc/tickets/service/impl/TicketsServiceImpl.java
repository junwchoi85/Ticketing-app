package com.jc.tickets.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jc.common.exception.ResourceNotFoundException;
import com.jc.tickets.dto.EventsDto;
import com.jc.tickets.dto.SeatsDto;
import com.jc.tickets.dto.TicketsDto;
import com.jc.tickets.entity.Events;
import com.jc.tickets.entity.Seats;
import com.jc.tickets.entity.Tickets;
import com.jc.tickets.mapper.EventsMapper;
import com.jc.tickets.mapper.SeatsMapper;
import com.jc.tickets.mapper.TicketsMapper;
import com.jc.tickets.repository.EventsRepository;
import com.jc.tickets.repository.SeatsRepository;
import com.jc.tickets.repository.TicketsRepository;
import com.jc.tickets.service.ITicketsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketsServiceImpl implements ITicketsService {
    private final TicketsRepository ticketsRepository;
    private final SeatsRepository seatsRepository;
    private final EventsRepository eventsRepository;

    @Override
    public TicketsDto createTicket(TicketsDto ticketsDto) {
        Tickets tickets = TicketsMapper.convertToEntity(ticketsDto);
        Tickets savedTickets = ticketsRepository.save(tickets);
        return TicketsMapper.convertToDto(savedTickets);
    }

    @Override
    public TicketsDto getTicketByUserId(Long userId) {
        Tickets tickets = ticketsRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "userId", userId.toString()));
        return TicketsMapper.convertToDto(tickets);
    }

    @Override
    public boolean updateTicket(TicketsDto ticketsDto) {
        Tickets tickets = ticketsRepository.findByUserId(ticketsDto.getUserId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Ticket", "userId", ticketsDto.getUserId().toString()));
        Tickets updatedTickets = TicketsMapper.mapToEntity(ticketsDto, tickets);
        ticketsRepository.save(updatedTickets);
        return true;
    }

    @Override
    public boolean deleteTicket(TicketsDto ticketsDto) {
        Tickets tickets = ticketsRepository.findByUserId(ticketsDto.getUserId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Ticket", "userId", ticketsDto.getUserId().toString()));
        ticketsRepository.delete(tickets);
        return true;
    }

    @Override
    public List<SeatsDto> getSeats(Long eventId) {
        List<Seats> seats = seatsRepository.findByEventId(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Seats", "eventId", eventId.toString()));
        return SeatsMapper.convertToSeatsDtoList(seats);
    }

    @Override
    public EventsDto getEventByTitle(String title) {
        Events events = eventsRepository.findByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "title", title));
        return EventsMapper.convertToDto(events);
    }

    @Override
    public List<EventsDto> getAllEvents() {
        List<Events> events = eventsRepository.findAll();
        return EventsMapper.convertToEventsDtoList(events);
    }

}
