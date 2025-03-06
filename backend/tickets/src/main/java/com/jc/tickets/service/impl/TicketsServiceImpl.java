package com.jc.tickets.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jc.common.exception.ResourceNotFoundException;
import com.jc.tickets.constants.TicketsConstants;
import com.jc.tickets.dto.EventDto;
import com.jc.tickets.dto.SeatDto;
import com.jc.tickets.dto.TicketDto;
import com.jc.tickets.entity.Event;
import com.jc.tickets.entity.Seat;
import com.jc.tickets.entity.Ticket;
import com.jc.tickets.mapper.EventMapper;
import com.jc.tickets.mapper.SeatMapper;
import com.jc.tickets.mapper.TicketMapper;
import com.jc.tickets.repository.EventRepository;
import com.jc.tickets.repository.SeatRepository;
import com.jc.tickets.repository.TicketRepository;
import com.jc.tickets.service.ITicketService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketsServiceImpl implements ITicketService {
    private final TicketRepository ticketsRepository;
    private final SeatRepository seatsRepository;
    private final EventRepository eventsRepository;

    @Override
    public TicketDto bookTicket(TicketDto ticketDto) {
        Ticket ticket = TicketMapper.convertToEntity(ticketDto);
        Ticket savedEntity = ticketsRepository.save(ticket);
        return TicketMapper.convertToDto(savedEntity);
    }

    @Override
    public List<TicketDto> getTicketByUser(String cusUuid) {
        List<Ticket> ticketList = ticketsRepository.findByCusUuid(cusUuid)
                .orElseThrow(() -> new ResourceNotFoundException(TicketsConstants.RESOURCE_TICKET,
                        TicketsConstants.FIELD_CUS_UUID, cusUuid));
        return TicketMapper.convertToDto(ticketList);
    }

    @Override
    public boolean updateTicket(TicketDto ticketDto) {
        Ticket ticket = ticketsRepository.findByTicUuid(ticketDto.getTicUuid())
                .orElseThrow(() -> new ResourceNotFoundException(TicketsConstants.RESOURCE_TICKET,
                        TicketsConstants.FIELD_TIC_UUID, ticketDto.getTicUuid()));
        Ticket updatedEntity = TicketMapper.mapToEntity(ticketDto, ticket);
        ticketsRepository.save(updatedEntity);
        return true;
    }

    @Override
    public boolean deleteTicket(TicketDto ticketDto) {
        // TODO : Implement soft delete
        Ticket ticket = ticketsRepository.findByTicUuid(ticketDto.getTicUuid())
                .orElseThrow(() -> new ResourceNotFoundException(TicketsConstants.RESOURCE_TICKET,
                        TicketsConstants.FIELD_TIC_UUID, ticketDto.getTicUuid()));
        ticketsRepository.delete(ticket);
        return true;
    }

    @Override
    public List<SeatDto> getSeats(String eveUuid) {
        List<Seat> seats = seatsRepository.findByEveUuid(eveUuid);
        return SeatMapper.convertToSeatDtoList(seats);
    }

    @Override
    public EventDto getEventByTitle(String title) {
        Event events = eventsRepository.findByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "title", title));
        return EventMapper.convertToDto(events);
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventsRepository.findAll();
        return EventMapper.convertToEventDtoList(events);
    }

}
