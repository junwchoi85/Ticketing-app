package com.jc.tickets.service;

import java.util.List;

import com.jc.tickets.dto.EventDto;
import com.jc.tickets.dto.SeatDto;
import com.jc.tickets.dto.TicketDto;

public interface ITicketService {
    public TicketDto bookTicket(TicketDto ticketDto);
    public List<TicketDto> getTicketByUser(String cusUuid);
    public boolean updateTicket(TicketDto ticketDto);
    public boolean deleteTicket(TicketDto ticketDto);

    public List<SeatDto> getSeats(String eveUuid);
    
    public EventDto getEventByTitle(String title);
    public List<EventDto> getAllEvents();
}
