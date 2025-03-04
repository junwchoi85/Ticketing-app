package com.jc.tickets.service;

import java.util.List;

import com.jc.tickets.dto.EventsDto;
import com.jc.tickets.dto.SeatsDto;
import com.jc.tickets.dto.TicketsDto;

public interface ITicketsService {
    public TicketsDto bookTicket(TicketsDto ticketsDto);
    public TicketsDto getTicketByUser(String cusUuid);
    public boolean updateTicket(TicketsDto ticketsDto);
    public boolean deleteTicket(TicketsDto ticketsDto);

    public List<SeatsDto> getSeats(String eveUuid);
    
    public EventsDto getEventByTitle(String title);
    public List<EventsDto> getAllEvents();
}
