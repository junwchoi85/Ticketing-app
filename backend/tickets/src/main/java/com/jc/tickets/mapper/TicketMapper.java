package com.jc.tickets.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.jc.tickets.dto.TicketDto;
import com.jc.tickets.entity.Ticket;

public class TicketMapper {
    public static TicketDto mapToDto(Ticket ticket, TicketDto ticketDto) {
        ticketDto.setTicUuid(ticket.getTicUuid());
        ticketDto.setEveUuid(ticket.getEveUuid());
        ticketDto.setSeaUuid(ticket.getSeaUuid());
        ticketDto.setCusUuid(ticket.getCusUuid());
        ticketDto.setPurchaseDate(ticket.getPurchaseDate());
        ticketDto.setPaymentStatus(ticket.getPaymentStatus());
        return ticketDto;
    }

    public static Ticket mapToEntity(TicketDto ticketDto, Ticket ticket) {
        ticket.setTicUuid(ticketDto.getTicUuid());
        ticket.setEveUuid(ticketDto.getEveUuid());
        ticket.setSeaUuid(ticketDto.getSeaUuid());
        ticket.setCusUuid(ticketDto.getCusUuid());
        ticket.setPurchaseDate(ticketDto.getPurchaseDate());
        ticket.setPaymentStatus(ticketDto.getPaymentStatus());
        return ticket;
    }

    public static TicketDto convertToDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicUuid(ticket.getTicUuid());
        ticketDto.setEveUuid(ticket.getEveUuid());
        ticketDto.setSeaUuid(ticket.getSeaUuid());
        ticketDto.setCusUuid(ticket.getCusUuid());
        ticketDto.setPurchaseDate(ticket.getPurchaseDate());
        ticketDto.setPaymentStatus(ticket.getPaymentStatus());
        return ticketDto;
    }

    public static Ticket convertToEntity(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setTicUuid(ticketDto.getTicUuid());
        ticket.setEveUuid(ticketDto.getEveUuid());
        ticket.setSeaUuid(ticketDto.getSeaUuid());
        ticket.setCusUuid(ticketDto.getCusUuid());
        ticket.setPurchaseDate(ticketDto.getPurchaseDate());
        ticket.setPaymentStatus(ticketDto.getPaymentStatus());
        return ticket;
    }

    public static List<TicketDto> convertToDto(List<Ticket> ticketList) {
        return ticketList.stream().map(TicketMapper::convertToDto).collect(Collectors.toList());
    }

    public static List<Ticket> convertToEntity(List<TicketDto> ticketDtoList) {
        return ticketDtoList.stream().map(TicketMapper::convertToEntity).collect(Collectors.toList());
    }
}
