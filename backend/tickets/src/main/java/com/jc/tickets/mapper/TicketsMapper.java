package com.jc.tickets.mapper;

import com.jc.tickets.dto.TicketsDto;
import com.jc.tickets.entity.Tickets;

public class TicketsMapper {
    public static TicketsDto mapToDto(Tickets tickets, TicketsDto ticketsDto) {
        ticketsDto.setTicUuid(tickets.getTicUuid());
        ticketsDto.setEveUuid(tickets.getEveUuid());
        ticketsDto.setSeaUuid(tickets.getSeaUuid());
        ticketsDto.setCusUuid(tickets.getCusUuid());
        ticketsDto.setPurchaseDate(tickets.getPurchaseDate());
        ticketsDto.setPaymentStatus(tickets.getPaymentStatus());
        return ticketsDto;
    }

    public static Tickets mapToEntity(TicketsDto ticketsDto, Tickets tickets) {
        tickets.setTicUuid(ticketsDto.getTicUuid());
        tickets.setEveUuid(ticketsDto.getEveUuid());
        tickets.setSeaUuid(ticketsDto.getSeaUuid());
        tickets.setCusUuid(ticketsDto.getCusUuid());
        tickets.setPurchaseDate(ticketsDto.getPurchaseDate());
        tickets.setPaymentStatus(ticketsDto.getPaymentStatus());
        return tickets;
    }

    public static TicketsDto convertToDto(Tickets tickets) {
        TicketsDto ticketsDto = new TicketsDto();
        ticketsDto.setTicUuid(tickets.getTicUuid());
        ticketsDto.setEveUuid(tickets.getEveUuid());
        ticketsDto.setSeaUuid(tickets.getSeaUuid());
        ticketsDto.setCusUuid(tickets.getCusUuid());
        ticketsDto.setPurchaseDate(tickets.getPurchaseDate());
        ticketsDto.setPaymentStatus(tickets.getPaymentStatus());
        return ticketsDto;
    }

    public static Tickets convertToEntity(TicketsDto ticketsDto) {
        Tickets tickets = new Tickets();
        tickets.setTicUuid(ticketsDto.getTicUuid());
        tickets.setEveUuid(ticketsDto.getEveUuid());
        tickets.setSeaUuid(ticketsDto.getSeaUuid());
        tickets.setCusUuid(ticketsDto.getCusUuid());
        tickets.setPurchaseDate(ticketsDto.getPurchaseDate());
        tickets.setPaymentStatus(ticketsDto.getPaymentStatus());
        return tickets;
    }
}
