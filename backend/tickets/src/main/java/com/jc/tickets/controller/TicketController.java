package com.jc.tickets.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.common.dto.ResponseDto;
import com.jc.tickets.constants.TicketsConstants;
import com.jc.tickets.dto.TicketDto;
import com.jc.tickets.service.ITicketService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@Validated
public class TicketController {
    private ITicketService ticketService;

    @PostMapping("/book-ticket")
    public ResponseEntity<ResponseDto<TicketDto>> bookTicket(@Valid @RequestBody TicketDto entity) {
        TicketDto savedEntity = ticketService.bookTicket(entity);
        if (savedEntity == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(TicketsConstants.STATUS_500, TicketsConstants.FAILED_TO_BOOK_TICKET, null));
        }
        return ResponseEntity.status(201)
                .body(new ResponseDto<>(TicketsConstants.STATUS_201, TicketsConstants.TICKET_BOOKED_SUCCESSFULLY,
                        null));
    }

    @GetMapping("/get-ticket")
    public ResponseEntity<ResponseDto<List<TicketDto>>> getTicket(@RequestParam("uuid") String uuid) {
        List<TicketDto> ticketList = ticketService.getTicketByUser(uuid);

        if (ticketList == null || ticketList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto<>(TicketsConstants.STATUS_500, TicketsConstants.TICKET_NOT_FOUND, null));
        }

        return ResponseEntity.status(200)
                .body(new ResponseDto<List<TicketDto>>(TicketsConstants.STATUS_200,
                        TicketsConstants.TICKET_BOOKED_SUCCESSFULLY, ticketList));
    }

    @GetMapping("/ticket-service-ping")
    public String ping() {
        return "ticket service pong";
    }

}
