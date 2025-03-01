package com.jc.tickets.mapper;

import com.jc.tickets.dto.TicketsDto;
import com.jc.tickets.entity.Tickets;

public class TicketsMapper {
    public static TicketsDto mapToDto(Tickets tickets, TicketsDto ticketsDto) {
        ticketsDto.setEventId(tickets.getEventId());
        ticketsDto.setSeatId(tickets.getSeatId());
        ticketsDto.setUserId(tickets.getUserId());
        ticketsDto.setPurchaseDate(tickets.getPurchaseDate());
        ticketsDto.setPaymentStatus(tickets.getPaymentStatus());
        return ticketsDto;
    }

    public static Tickets mapToEntity(TicketsDto ticketsDto, Tickets tickets) {
        tickets.setEventId(ticketsDto.getEventId());
        tickets.setSeatId(ticketsDto.getSeatId());
        tickets.setUserId(ticketsDto.getUserId());
        tickets.setPurchaseDate(ticketsDto.getPurchaseDate());
        tickets.setPaymentStatus(ticketsDto.getPaymentStatus());
        return tickets;
    }

    public static TicketsDto convertToDto(Tickets tickets) {
        TicketsDto ticketsDto = new TicketsDto();
        ticketsDto.setEventId(tickets.getEventId());
        ticketsDto.setSeatId(tickets.getSeatId());
        ticketsDto.setUserId(tickets.getUserId());
        ticketsDto.setPurchaseDate(tickets.getPurchaseDate());
        ticketsDto.setPaymentStatus(tickets.getPaymentStatus());
        return ticketsDto;
    }

    public static Tickets convertToEntity(TicketsDto ticketsDto) {
        Tickets tickets = new Tickets();
        tickets.setEventId(ticketsDto.getEventId());
        tickets.setSeatId(ticketsDto.getSeatId());
        tickets.setUserId(ticketsDto.getUserId());
        tickets.setPurchaseDate(ticketsDto.getPurchaseDate());
        tickets.setPaymentStatus(ticketsDto.getPaymentStatus());
        return tickets;
    }
}
