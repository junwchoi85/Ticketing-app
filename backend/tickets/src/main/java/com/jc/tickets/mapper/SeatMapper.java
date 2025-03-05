package com.jc.tickets.mapper;

import java.util.ArrayList;
import java.util.List;

import com.jc.tickets.dto.SeatDto;
import com.jc.tickets.entity.Seat;

public class SeatMapper {
    public static SeatDto mapToDto(Seat seat, SeatDto seatDto) {
        seatDto.setSeaUuid(seat.getSeaUuid());
        seatDto.setEveUuid(seat.getEveUuid());
        seatDto.setSeatNumber(seat.getSeatNumber());
        seatDto.setRowNumber(seat.getRowNumber());
        seatDto.setStatus(seat.getStatus());
        seatDto.setReservedBy(seat.getReservedBy());
        seatDto.setReservedUntil(seat.getReservedUntil());
        return seatDto;
    }

    public static Seat mapToEntity(SeatDto seatDto, Seat seat) {
        seat.setSeaUuid(seatDto.getSeaUuid());
        seat.setEveUuid(seatDto.getEveUuid());
        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setRowNumber(seatDto.getRowNumber());
        seat.setStatus(seatDto.getStatus());
        seat.setReservedBy(seatDto.getReservedBy());
        seat.setReservedUntil(seatDto.getReservedUntil());
        return seat;
    }

    public static SeatDto convertToDto(Seat seat) {
        SeatDto seatDto = new SeatDto();
        seatDto.setSeaUuid(seat.getSeaUuid());
        seatDto.setEveUuid(seat.getEveUuid());
        seatDto.setSeatNumber(seat.getSeatNumber());
        seatDto.setRowNumber(seat.getRowNumber());
        seatDto.setStatus(seat.getStatus());
        seatDto.setReservedBy(seat.getReservedBy());
        seatDto.setReservedUntil(seat.getReservedUntil());
        return seatDto;
    }

    public static Seat convertToEntity(SeatDto seatDto) {
        Seat seat = new Seat();
        seat.setSeaUuid(seatDto.getSeaUuid());
        seat.setEveUuid(seatDto.getEveUuid());
        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setRowNumber(seatDto.getRowNumber());
        seat.setStatus(seatDto.getStatus());
        seat.setReservedBy(seatDto.getReservedBy());
        seat.setReservedUntil(seatDto.getReservedUntil());
        return seat;
    }

    public static List<SeatDto> convertToSeatDtoList(List<Seat> seatList) {
        List<SeatDto> seatDtoList = new ArrayList<>();
        for (Seat seat : seatList) {
            SeatDto seatDto = new SeatDto();
            seatDto.setSeaUuid(seat.getSeaUuid());
            seatDto.setEveUuid(seat.getEveUuid());
            seatDto.setSeatNumber(seat.getSeatNumber());
            seatDto.setRowNumber(seat.getRowNumber());
            seatDto.setStatus(seat.getStatus());
            seatDto.setReservedBy(seat.getReservedBy());
            seatDto.setReservedUntil(seat.getReservedUntil());
            seatDtoList.add(seatDto);
        }
        return seatDtoList;
    }
}
