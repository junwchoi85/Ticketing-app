package com.jc.tickets.controller;

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
import com.jc.tickets.dto.TicketsDto;
import com.jc.tickets.service.ITicketsService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@Validated
public class TicketsController {
    private ITicketsService ticketsService;

    @PostMapping("/book-ticket")
    public ResponseEntity<ResponseDto<TicketsDto>> bookTicket(@Valid @RequestBody TicketsDto entity) {
        TicketsDto savedEntity = ticketsService.bookTicket(entity);
        if (savedEntity == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(TicketsConstants.STATUS_500, TicketsConstants.FAILED_TO_BOOK_TICKET, null));
        }
        return ResponseEntity.status(201)
                .body(new ResponseDto<>(TicketsConstants.STATUS_201, TicketsConstants.TICKET_BOOKED_SUCCESSFULLY,
                        null));
    }

    @GetMapping("/get-ticket")
    public ResponseEntity<ResponseDto<TicketsDto>> getTicket(@RequestParam("uuid") String uuid) {
        TicketsDto entity = ticketsService.getTicketByUser(uuid);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(TicketsConstants.STATUS_500, TicketsConstants.FAILED_TO_BOOK_TICKET, null));
        }
        return ResponseEntity.status(200)
                .body(new ResponseDto<>(TicketsConstants.STATUS_200, TicketsConstants.TICKET_BOOKED_SUCCESSFULLY, entity));
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
    

}
