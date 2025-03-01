package com.jc.tickets.mapper;

import java.util.ArrayList;
import java.util.List;

import com.jc.tickets.dto.SeatsDto;
import com.jc.tickets.entity.Seats;

public class SeatsMapper {
    public static SeatsDto mapToDto(Seats seats, SeatsDto seatsDto) {
        seatsDto.setSeatNumber(seats.getSeatNumber());
        seatsDto.setRowNumber(seats.getRowNumber());
        seatsDto.setStatus(seats.getStatus());
        seatsDto.setReservedBy(seats.getReservedBy());
        seatsDto.setReservedUntil(seats.getReservedUntil());
        return seatsDto;
    }

    public static Seats mapToEntity(SeatsDto seatsDto, Seats seats) {
        seats.setSeatNumber(seatsDto.getSeatNumber());
        seats.setRowNumber(seatsDto.getRowNumber());
        seats.setStatus(seatsDto.getStatus());
        seats.setReservedBy(seatsDto.getReservedBy());
        seats.setReservedUntil(seatsDto.getReservedUntil());
        return seats;
    }

    public static SeatsDto convertToDto(Seats seats) {
        SeatsDto seatsDto = new SeatsDto();
        seatsDto.setSeatNumber(seats.getSeatNumber());
        seatsDto.setRowNumber(seats.getRowNumber());
        seatsDto.setStatus(seats.getStatus());
        seatsDto.setReservedBy(seats.getReservedBy());
        seatsDto.setReservedUntil(seats.getReservedUntil());
        return seatsDto;
    }

    public static Seats convertToEntity(SeatsDto seatsDto) {
        Seats seats = new Seats();
        seats.setSeatNumber(seatsDto.getSeatNumber());
        seats.setRowNumber(seatsDto.getRowNumber());
        seats.setStatus(seatsDto.getStatus());
        seats.setReservedBy(seatsDto.getReservedBy());
        seats.setReservedUntil(seatsDto.getReservedUntil());
        return seats;
    }

    public static List<SeatsDto> convertToSeatsDtoList(List<Seats> seats) {
        List<SeatsDto> seatsDtoList = new ArrayList<>();
        for (Seats seat : seats) {
            SeatsDto seatsDto = new SeatsDto();
            seatsDto.setSeatNumber(seat.getSeatNumber());
            seatsDto.setRowNumber(seat.getRowNumber());
            seatsDto.setStatus(seat.getStatus());
            seatsDto.setReservedBy(seat.getReservedBy());
            seatsDto.setReservedUntil(seat.getReservedUntil());
            seatsDtoList.add(seatsDto);
        }
        return seatsDtoList;
    }
}
